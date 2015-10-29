package com.potatoesteam.app.bean;

import com.potatoesteam.app.frame.ClienteFrame;
import com.potatoesteam.app.service.ClienteService;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionSetup {
    
    public static Socket socket;
    public static ChatMessage message;
    public static ClienteService service;
    public static String nickName = "";
    public static Thread currentListenerSocket = null;
    public static String[] setOnlines = null;
      
    
}

