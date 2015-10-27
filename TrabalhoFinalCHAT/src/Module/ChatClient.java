/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author amanda
 */
public abstract class ChatClient implements Runnable {
    protected String            nick;
    protected Socket            client;
    protected PrintWriter       mandador;
    protected BufferedReader    receptor;
    protected ChatHandler       handler;
    
    private DataOutputStream dout;
    private DataInputStream din;
    
    public ChatClient (String host, int PORT) {
        try {

            client = new Socket(host, PORT);

            System.out.println("connected to " + client );

            din = new DataInputStream(client.getInputStream());
            dout = new DataOutputStream(client.getOutputStream());

            new Thread(this).start();
            } catch(IOException ie) { 
                System.out.println(ie); 
            }
        }
    }
    
    private void processMessage(String message) {
        try {
            dout.writeUTF(message);
            tf.setText("");
        } catch(IOException ie) { 
            System.out.println(ie); 
        }
    }

    public static void main(String args[]) throws UnknownHostException, IOException {
//        Socket client = new Socket("127.0.0.1", ChatServer.PORT);
//        System.out.println("Client connected to server.");
//        
//        Scanner keyboard = new Scanner(System.in);
//        PrintStream output = new PrintStream(client.getOutputStream());
//        
//        while(keyboard.hasNextLine()) {
//            output.println(keyboard.nextLine());    
//        }
//        
//        output.close();
//        keyboard.close();
        try {
            while (true) {
                String message = din.readUTF();
            //panel to print message to:
                ta.append(message + "\n");
            }
        } catch( IOException ie ) { 
            System.out.println( ie ); 
        }
    }
    
}
