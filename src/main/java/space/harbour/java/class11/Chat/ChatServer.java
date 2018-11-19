package space.harbour.java.class11.Chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {

    Set<ClientHandler> clients = new HashSet<>();

    public ChatServer(int port) {
            try (ServerSocket server = new ServerSocket(port)) {
                while (true) {
                    ClientHandler client = new ClientHandler(this, server.accept());
                    clients.add(client);
                    client.start();
                }
            } catch (IOException e) {
                System.out.println("The server failed on port: " + port);
            }

    }

    public synchronized void broadcast(String message) {
        for(ClientHandler client: clients) {
            client.sendMessage(message);
        }
    }

    public void clientDisconnected(ClientHandler client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        new ChatServer(8008);
    }
}
