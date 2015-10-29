package src.com.potatoesteam.app.services;

import src.com.potatoesteam.app.beans.ServidorChatMessage;
import src.com.potatoesteam.app.beans.ServidorChatMessage.Action;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.awt.windows.ThemeReader;

/**
 * Classe que provém o serviço para o Servidor.
 * @author Bianca Pereira
 */
public class ServidorService {

    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnlineUsers = new HashMap<String, ObjectOutputStream>();

    public ServidorService() {
        try {
            serverSocket = new ServerSocket(12345);

            serverSocket.setSoTimeout(0);
            
            System.out.println("Servidor on!");

            while (true) {
                socket = serverSocket.accept();

                new Thread(new ListenerSocket(socket)).start();
            }

        } catch (IOException ex) {
            Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ListenerSocket implements Runnable {

        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ListenerSocket(Socket socket) {
            try {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream (socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void run() {
            ServidorChatMessage message = null;
            try {
                while ((message = (ServidorChatMessage) input.readObject()) != null) {
                    Action action = message.getAction();

                    if (action.equals(Action.CONNECT)) {
                        boolean isConnect = connect(message, output);
                        if (isConnect) {
                            mapOnlineUsers.put(message.getName(), output);
                            sendOnlineUsers();
                        }
                    } else if (action.equals(Action.DISCONNECT)) {
                        disconnect(message, output);
                        sendOnlineUsers();
                        return;
                    } else if (action.equals(Action.SEND_ONE)) {
                        sendOne(message);
                    } else if (action.equals(Action.SEND_ALL)) {
                        sendAll(message);
                    }
                }
            } catch (IOException ex) {
                ServidorChatMessage cm = new ServidorChatMessage();
                cm.setName(message.getName());
                disconnect(cm, output);
                sendOnlineUsers();
                System.out.println(message.getName() + " deixou o chat!");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private boolean connect(ServidorChatMessage message, ObjectOutputStream output) {
        if (mapOnlineUsers.size() == 0) {
            message.setText("YES");
            send(message, output);
            return true;
        }

        if (mapOnlineUsers.containsKey(message.getName())) {
            message.setText("NO");
            send(message, output);
            return false;
        } else {
            message.setText("YES");
            send(message, output);
            return true;
        }
    }

    private void disconnect(ServidorChatMessage message, ObjectOutputStream output) {
        mapOnlineUsers.remove(message.getName());

        message.setText(" até logo!");

        message.setAction(Action.SEND_ONE);

        sendAll(message);

        System.out.println("User " + message.getName() + " sai da sala");
    }

    private void send(ServidorChatMessage message, ObjectOutputStream output) {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendOne(ServidorChatMessage message) {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlineUsers.entrySet()) {
            if (kv.getKey().equals(message.getNameReserved())) {
                try {
                    kv.getValue().writeObject(message);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void sendAll(ServidorChatMessage message) {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlineUsers.entrySet()) {
            if (!kv.getKey().equals(message.getName())) {
                message.setAction(Action.SEND_ONE);
                try {
                    kv.getValue().writeObject(message);
                } catch (IOException ex) {
                    Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void sendOnlineUsers() {
        Set<String> setNames = new HashSet<String>();
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlineUsers.entrySet()) {
            setNames.add(kv.getKey());
        }

        ServidorChatMessage message = new ServidorChatMessage();
        message.setAction(Action.USERS_ONLINE);
        message.setSetOnlineUsers(setNames);

        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlineUsers.entrySet()) {
            message.setName(kv.getKey());
            try {
                kv.getValue().writeObject(message);
            } catch (IOException ex) {
                Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
//TODO: ver erro linha 