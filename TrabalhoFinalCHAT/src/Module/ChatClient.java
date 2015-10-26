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
public class ChatClient {
    public static void main(String args[]) throws UnknownHostException, IOException {
        Socket client = new Socket("127.0.0.1", 5000);
        System.out.println("Client connected to server.");
        
        Scanner keyboard = new Scanner(System.in);
        PrintStream output = new PrintStream(client.getOutputStream());
        
        while(keyboard.hasNextLine()) {
            output.println(keyboard.nextLine());    
        }
        
        output.close();
        keyboard.close();
    }
}
