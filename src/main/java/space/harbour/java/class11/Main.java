package space.harbour.java.class11;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        String host = "google.com";
        try {
            InetAddress ip = InetAddress.getByName(host);
            System.out.println("IP address: " + ip.getHostAddress());
        }
        catch (UnknownHostException e) {
            System.out.println("Could not find IP address fo: " + host);
        }
    }
}
