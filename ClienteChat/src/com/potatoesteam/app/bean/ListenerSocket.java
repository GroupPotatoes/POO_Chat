package com.potatoesteam.app.bean;

import com.potatoesteam.app.frame.ClienteFrame;
import com.potatoesteam.app.frame.ConversationWindow;
import com.potatoesteam.app.frame.TelaPrincipal;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ListenerSocket implements Runnable {

        private ObjectInputStream input;
        private TelaPrincipal telaPrincipal;
        private ConversationWindow conversationWindow;
        
        
        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            ChatMessage message = null;
            try {
                while ((message = (ChatMessage) input.readObject()) != null) {
                    ChatMessage.Action action = message.getAction();

                    if (action.equals(ChatMessage.Action.CONNECT)) {
                        connected(message);
                    }
                    /*else if (action.equals(Action.DISCONNECT)) {
                        disconnected();
                        socket.close();
                    }*/ else if (action.equals(ChatMessage.Action.SEND_ONE)) {
                        System.out.println("::: " + message.getText() + " :::");
                        receive(message);
                    } else if (action.equals(ChatMessage.Action.USERS_ONLINE)) {
                           refreshOnlines(message);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    private void connected(ChatMessage message) {
    if (!message.getText().equals("NO")) {

    ConnectionSetup.message = message;
    JOptionPane.showMessageDialog(null, "Você está conectado no chat!");
    
    this.telaPrincipal = new TelaPrincipal();
    telaPrincipal.setVisible(true);
    
    }
    else
        JOptionPane.showMessageDialog(null, "ERRO AO FAZER CONEXÃO");

}

    private void refreshOnlines(ChatMessage message) {
        
        message.setAction(ChatMessage.Action.USERS_ONLINE);
        System.out.println(message.getSetOnlines().toString());
        
        Set<String> names = message.getSetOnlines();
        
        names.remove(message.getName());
        
        String[] array = (String[]) names.toArray(new String[names.size()]);
        
        ConnectionSetup.setOnlines = array;
        
        telaPrincipal.refreshOnlines();
    }   
 
    private void receive(ChatMessage message) {
        if(conversationWindow == null)
            conversationWindow = new ConversationWindow();
        
        conversationWindow.setConversas(message.getName() + " diz: " + message.getText() + "\n");
    }

}
    