//package space.harbour.java.hw6;
//
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.TimeUnit;
//
//public class Crawler implements Runnable{
//
//    private final String url;
//    private final ExecutorService executor;
//    private final Set<String> alreadyVisitet;
//
//    public Crawler(String url, ExecutorService executor, Set<String> alreadyVisitet) {
//        this.url = url;
//        this.executor = executor;
//        this.alreadyVisitet = alreadyVisitet;
//    }
//
//    @Override
//    public void run() {
//        try {
//            List<String> links = getLinks();
//            for(String newUrl : links){
//                if(!this.alreadyVisitet.contains(newUrl)){
//                    this.alreadyVisitet.add(newUrl);
//                    executor.submit(new Crawler(newUrl, executor, alreadyVisitet));
//                }
//            }
//
//        } catch (IOException e) {
////            e.printStackTrace();
//        }
//    }
//
//    private List<String> getLinks() throws IOException {
//        ArrayList<String> result = new ArrayList<>();
//        String url = this.url;
//        Document doc = Jsoup.connect(url).get();// enter the url
//        Elements links1 = doc.select("a[href]");
//
//        for (Element link : links1) {
//            result.add(link.attr("href"));
//        }
//        return result;
//    }
//
//
//    public static void main(String[] args) throws InterruptedException {
//
//        ExecutorService executorService = Executors.newFixedThreadPool(7);
//        Set<String> alreadyVisited = ConcurrentHashMap.newKeySet();
//        String rootUrl = "http://codeforces.com/";
//        alreadyVisited.add(rootUrl);
//        executorService.submit(new Crawler(rootUrl, executorService, alreadyVisited));
//
//        //Let the crawler run for 10 seconds before it stops accepting incoming urls
//        Thread.sleep(1000L * 2);
//        executorService.shutdown();
//
//        try {
//            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
//                executorService.shutdownNow();
//                if (!executorService.awaitTermination(60, TimeUnit.SECONDS))
//                    System.err.println("Pool did not terminate");
//            }
//        } catch (InterruptedException ie) {
//            executorService.shutdownNow();
//            Thread.currentThread().interrupt();
//        }
//
//        for(String link: alreadyVisited){
//            System.out.println(link);
//        }
//    }
//}