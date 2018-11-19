package space.harbour.java.class11.Chat;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
    public final String name;

    public final String server;
    public final int port;

    public ChatClient(String name, String server, int port) {
        this.name = name;
        this.server = server;
        this.port = port;

        try (Socket conn = new Socket(server, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));

            out.println(name);
            out.flush();

            Scanner scanner = new Scanner(System.in);

            while (true) {
                // if there is a message on the server then print it
                System.out.println(in.readLine());

                // if there is a message on keyboard the send it to server
                if (scanner.hasNext()) {
                    out.println(scanner.hasNext());
                    out.flush();
                }
            }

        } catch (UnknownHostException e) {
            System.out.println("The server cannot be found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ChatClient(args[0], "127.0.0.1", 8008);
    }
}
