package space.harbour.java.class11;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ApacheHTTPClient {
    public static void main(String[] args) {
        String url = "http://httpbin.org/post";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        try {
            List<NameValuePair> pairs = new ArrayList<>(1);
            pairs.add(new BasicNameValuePair("q", "Beatles Yellow Submarine"));
            pairs.add(new BasicNameValuePair("name", "Harbour"));
            post.setEntity(new UrlEncodedFormEntity(pairs));

            HttpResponse response = client.execute(post);

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(post.getEntity().getContent()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
