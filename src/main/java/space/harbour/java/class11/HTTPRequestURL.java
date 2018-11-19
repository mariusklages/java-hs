package space.harbour.java.class11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class HTTPRequestURL {
    public static void main(String[] args) {
        String webpage = "http://www.columbia.edu/~fdc/sample.html";
        try {
            URL url = new URL(webpage);
            BufferedReader inr = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String line;
            while ((line = inr.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
