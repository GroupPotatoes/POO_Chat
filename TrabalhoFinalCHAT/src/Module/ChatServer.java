/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amanda
 */
public class ChatServer {

    static int PORT;
    ServerSocket server;
    private Hashtable outputStreams = new Hashtable();

    public ChatServer(int PORT) throws IOException {
        listen(PORT);
        ChatServer.PORT = PORT;
    }

    private void listen(int PORT) {
        try {
            this.server = new ServerSocket(PORT);
            System.out.println("Socket is open on port " + PORT);

            Vector<ChatClient> users = new Vector<ChatClient>();

            while (true) {
                try {
                    Socket client = this.server.accept();
                    ChatHandler handler = new ChatHandler(users, client);

                    Thread t = new Thread(handler);
                    t.start();
                    System.out.println("CLIENT CONNECTED: " + client.getInetAddress().getHostAddress());
                    Scanner scanner = new Scanner(client.getInputStream());

                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }

                    DataOutputStream dout = new DataOutputStream(client.getOutputStream());

                    outputStreams.put(client, dout);

                    new ChatHandler(this, client);
//                    client.close();
//                    scanner.close();
//                    this.server.close();
                } catch (IOException ex) {
                    Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Enumeration getOutputStreams() {
        return outputStreams.elements();
    }

    void sendToAll(String message) {

        synchronized (outputStreams) {
            for (Enumeration e = getOutputStreams(); e.hasMoreElements();) {
                DataOutputStream dout = (DataOutputStream) e.nextElement();
                try {
                    dout.writeUTF(message);
                } catch (IOException ie) {
                    System.out.println(ie);
                }
            }
        }
    }

    void removeConnection(Socket client) {
        synchronized (outputStreams) {
            System.out.println("Removing connection to " + client);
            outputStreams.remove(client);
            try {
                client.close();
            } catch (IOException ie) {
                System.out.println("Error closing " + client);
                ie.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws IOException {
        int port = Integer.parseInt(args[0]);
        new ChatServer( port );
    }

}
