package space.harbour.java.class11;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionClass {
    public static void main(String[] args) throws IOException {

//        String webpage = "http://www.columbia.edu/~fdc/samplefaessfe.html";
//        String webpage = "http://www.columbia.edu/~fdc/sample.html";
//        String webpage = "https://harbour.space";
        String webpage = "https://www.google.com/search?q=something";

        try {
            URL url = new URL(webpage);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            System.out.println(conn.getResponseCode());
            System.out.println(conn.getResponseMessage());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
