package space.harbour.java.hw11;

import org.bson.Document;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatHandler extends Thread {
    private final ChatServer server;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    public final String name;

    public ChatHandler(ChatServer server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        name = in.readUTF();
        server.broadcast(name, "has joined from " + socket.getInetAddress());

        for (Document doc: server.chatDatabase.getChats()) {
            String user = doc.getString(ChatDatabase.USER_FIELD);
            String chat = doc.getString(ChatDatabase.CHAT_FIELD);
            out.writeUTF(user + ": " + chat);
        }
        out.flush();
    }

    public void run() {
        try (socket; in; out) {
            while (true) {
                String msg = in.readUTF();
                if (msg == null)
                    break;
                server.broadcast(name, msg);
            }
        } catch (IOException e) {
            System.out.println("Connection to user is lost");
        }
        server.chatDisconnected(this);
    }

    public void sendMessage(String user, String message) {
        try {
            out.writeUTF(user + ": " + message);
            out.flush();
        } catch (IOException e) {
            System.out.println("Connection to user is lost");
            server.chatDisconnected(this);
        }
    }
}
