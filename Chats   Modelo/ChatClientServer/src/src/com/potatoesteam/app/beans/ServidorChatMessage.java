package src.com.potatoesteam.app.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean que configura o servidor no chat.
 * @author Amanda Braz
 */
public class ServidorChatMessage implements Serializable {
    
    private String name;
    private String text;
    private String nameReserved;
    private Set<String> setOnlineUsers = new HashSet<String>();
    private Action action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNameReserved() {
        return nameReserved;
    }

    public void setNameReserved(String nameReserved) {
        this.nameReserved = nameReserved;
    }

    public Set<String> getSetOnlineUsers() {
        return setOnlineUsers;
    }

    public void setSetOnlineUsers(Set<String> setOnlineUsers) {
        this.setOnlineUsers = setOnlineUsers;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
        
    public enum Action {
        CONNECT, DISCONNECT, SEND_ONE, SEND_ALL, USERS_ONLINE
    }
}
