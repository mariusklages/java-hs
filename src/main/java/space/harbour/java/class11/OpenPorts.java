package space.harbour.java.class11;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class OpenPorts {
    public static void main(String[] args) throws IOException {
        String host = "google.com";

        try {
            InetAddress ip = InetAddress.getByName(host);
//            System.out.println(ip.getHostAddress());

            int port = 800;
            try (Socket s = new Socket(host, port)) {
                s.setSoTimeout(50);
                System.out.println("Service is running on port " + port);
            } catch (IOException e) {
                System.out.println("No service ion port " + port);
            }
        } catch (UnknownHostException e) {
            System.out.println("Hostname is incorrect");
        }

    }
}
