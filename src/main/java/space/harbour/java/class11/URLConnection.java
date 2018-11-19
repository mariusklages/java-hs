package space.harbour.java.class11;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLConnection {
    public static void main(String[] args) {
        String webpage = "http://www.columbia.edu/~fdc/sample.html";
        try {
            URL url = new URL(webpage);
            java.net.URLConnection conn = url.openConnection();
            Map<String, List<String>> headers = conn.getHeaderFields();

            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            for (Map.Entry<String, List<String>> entry: entrySet) {
                System.out.println("Header name: " + entry.getKey());
                System.out.println("Header value: " );
                List<String> values = entry.getValue();
                for (String value: values) {
                    System.out.println(value);
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
