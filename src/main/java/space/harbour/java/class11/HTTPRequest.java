package space.harbour.java.class11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class HTTPRequest {
    public static void main(String[] args) {
        String host = "www.columbia.edu";
        String file = "/~fdc/sample.html";
        int port = 80;

        try (Socket s = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(s.getOutputStream(), false);
            out.print("GET " + file + " HTTP/1.0\r\n");
            out.print("Accept: text/plain, text/html, text/*\r\n");
            out.print("\r\n");
            out.flush();

            InputStreamReader inr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(inr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
        } catch (IOException e) {
        }
    }
}
