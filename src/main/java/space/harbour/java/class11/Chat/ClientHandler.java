package space.harbour.java.class11.Chat;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final ChatServer server;
    private final Socket client;
    private final BufferedReader in;
    private final PrintWriter out;

    private final String name;

    public ClientHandler(ChatServer server, Socket client) throws IOException {
        this.server = server;
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

        name = in.readLine();
        System.out.println("A new client connected: " + name + " from: " + client.getInetAddress());
    }

    @Override
    public void run() {
        try {
        while (true) {
            String message = in.readLine();
            if (message == null) break;
            server.broadcast(message);
        }

        System.out.println("A client is disconnected: " + name);
        server.clientDisconnected(this);

            in.close();
            out.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        out.println(message);
        out.flush();
    }
}
