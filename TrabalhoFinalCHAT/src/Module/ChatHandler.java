/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.io.*;
import java.net.*;
import java.util.Vector;

/**
 *
 * @author amanda
 */
class ChatHandler extends Thread {
    private ChatServer server;
    private Socket client;
    protected ChatClient user;
    protected Vector<ChatClient> users;
    protected boolean end = false;

    ChatHandler(Vector<ChatClient> users, Socket client) {
        this.users = users;
        this.client = client;
        this.startChat();
    }
    public void startChat() {
        this.start();
    }
    public void closeChat() {
        this.end = true;
    }
    
    public void run() {
        try {
            DataInputStream din = new DataInputStream(client.getInputStream());
            while (true) {
                String message = din.readUTF();
                System.out.println("Sending " + message);
                server.sendToAll(message);
                
                
                
           //     String remetente    = this.usr.getReceptor().readLine();
           // String destinatario = this.usr.getReceptor().readLine();
           // String mensagem     = this.usr.getReceptor().readLine();

            // se destinatario e mensagem forem "sair", acha
            // remetente no vector e chama o metodo morra
            // caso contrario, procura o destinatario no vector
            // e manda a mensagem com o nick do remetente
            }
        }
        catch( EOFException ie ) {
        } catch( IOException ie ) {
            ie.printStackTrace();
        } finally {
            server.removeConnection(client);
        }
    }
}
