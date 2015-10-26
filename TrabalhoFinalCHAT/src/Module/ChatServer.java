/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author amanda
 */
public class ChatServer {
    public static void main(String args[]) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Socket is open");
        //Fazer um for com varias conexoes!
        
        Socket client = server.accept();
        //Usar um vector de clientes
        
        System.out.println("CLIENT CONNECTED: " + client.getInetAddress().getHostAddress()); 
        Scanner scanner = new Scanner(client.getInputStream());
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        
        scanner.close();
        server.close();
        client.close();
    }
}
