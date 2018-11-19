package space.harbour.java.hw11;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer {
    private Set<ChatHandler> chats = ConcurrentHashMap.newKeySet();
    ChatDatabase chatDatabase = new ChatDatabase();

    public ChatServer(int port) {
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                ChatHandler chat = new ChatHandler(this, s.accept());
                chats.add(chat);
                chat.start();

            }
        } catch (IOException e) {
            System.out.println("Server failed on port " + port);
        }
    }

    public synchronized void broadcast(String user, String message) {
        chatDatabase.addChat(user, message);
        System.out.println("[" + user + "] " + message);
        for (ChatHandler chat: chats) {
            chat.sendMessage(user, message);
        }
    }

    public void chatDisconnected(ChatHandler chat) {
        chats.remove(chat);
        broadcast(chat.name, "left");
    }

    public static void main(String[] args) {
        new ChatServer(8008);
    }
}