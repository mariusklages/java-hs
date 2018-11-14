package space.harbour.java.class8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class WebCrawler {

    private Queue<String> toVisit = new ConcurrentLinkedQueue<>();
    private Set<String> visiting = new ConcurrentSkipListSet<>();
    private Set<String> alreadyVisited = new ConcurrentSkipListSet<>();
    private Object s = new LinkedList<>();

    private final int NUM_THREADS = 10;

    private Executor executor = Executors.newFixedThreadPool(NUM_THREADS);


    public WebCrawler(String... urls) {
        Arrays.stream(urls).forEach(toVisit::add);
    }

    public void start() {
  //      IntStream.range(0, NUM_THREADS).forEach((i) -> {
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.execute(() -> {
                while (!toVisit.isEmpty() || !visiting.isEmpty()) {
                    if (toVisit.isEmpty()) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            Thread.interrupted();
                            return;
                        }
                        continue;
                    }
                    // above implemented to ensure it continues
                    String url = toVisit.poll();
                    visiting.add(url);

                    String content = getContentByURL(url);
                    List<String> links = getLinksFromContent(content);
                    links.stream()
                            .filter(s -> !alreadyVisited.contains(s))
                            .filter(s -> !visiting.contains(s))
                            .forEach(toVisit::add);

                    alreadyVisited.add(url);
                    visiting.remove(url);

                }
            });
        }
  //      });

    }

    private List<String> getLinksFromContent(String content) {
        return Collections.EMPTY_LIST;

        // this still needs to be input
    }

    private String getContentByURL(String strUrl) {
        try {
            URL url = new URL(strUrl);
            final StringBuilder content = new StringBuilder();

            try (InputStream is = url.openConnection().getInputStream();
                 InputStreamReader in = new InputStreamReader(is, "UTF-8");
                 BufferedReader br = new BufferedReader(in);) {
                String inputLine;
                while ((inputLine = br.readLine()) != null)
                    content.append(inputLine);
            } catch (IOException e) {
                System.out.println("Failed to retrieve content of " + url.toString());
                e.printStackTrace();
            }

            return content.toString();
        } catch (Exception e) {
            // f it
            return null;
        }
    }

    public static void main(String... args) {
        new WebCrawler("https://google.com").start();
    }


}
