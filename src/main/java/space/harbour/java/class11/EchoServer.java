package space.harbour.java.class11;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        final int port = 8008;
        ServerSocket s = new ServerSocket(port);


        while (true) {
            Socket client = s.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(
                    client.getOutputStream()));
            out.println("Hello! This is the Echo Server!");
            out.println("Enter BYE to exit");
            out.flush();

            String line;

            while ((line = in.readLine()) != null) {
                out.println("Echo: " + line);
                out.flush();
                if (line.trim().toUpperCase().equals("BYE")) break;
            }
            in.close();
            out.close();
            client.close();
            }
        }


    }
