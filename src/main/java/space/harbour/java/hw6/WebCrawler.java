//package space.harbour.java.hw6;
//
//import org.jsoup.Connection;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Set;
//
//public class WebCrawler {
//
//    static class Crawler implements Runnable {
//
//
//        private static final int MAX_PAGES_TO_SEARCH = 10;
//        private Set<String> pagesVisited = new HashSet<>();
//        private List<String> pagesToVisit = new LinkedList<>();
//        private List<String> links = new LinkedList<>();
//
////        public Crawler(String[] webPages) {
////            for (String page : webPages) {
////                try {
////                    URL urlAddress = new URL(page);
////                    pagesToVisit.offer(new MultiThreadCrawler.Webpage(urlAddress));
////                } catch (MalformedURLException e) {
////                }
////            }
////        }
//
//
//        // if URL visited it will be removed from toVisit and added to visited
//        // if URL already visited we will not visit it again
//
//
//        private String nextUrl() {
//            String nextUrl;
//            do {
//                nextUrl = this.pagesToVisit.remove(0);
//            } while (this.pagesVisited.contains(nextUrl));
//            this.pagesVisited.add(nextUrl);
//            return nextUrl;
//        }
//
//        public void search(String url) {
//            while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
//                String currentUrl;
//                // the one above is a new class to create
//                if (this.pagesToVisit.isEmpty()) {
//                    currentUrl = url;
//                    this.pagesVisited.add(url);
//                } else {
//                    currentUrl = this.nextUrl();
//                }
//
//                crawl(currentUrl);
//
//                // I think the 5 lines above can be ignored for our case right now since we are not looking for one word specifically
//                this.pagesToVisit.addAll(getLinks());
//            }
//            System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
//        }
//
//        public void crawl(String url) {
//            // give it a URL and it makes an HTTP request for a web page
//            try {
//                Connection connection = Jsoup.connect(url);
//                Document htmlDocument = connection.get();
////                this.htmlDocument = htmlDocument;
//
//                System.out.println("Received web page at " + url);
//
//                Elements linksOnPage = htmlDocument.select("a[href]");
//                System.out.println("Found (" + linksOnPage.size() + ") links");
//
//                for (Element link : linksOnPage) {
//                    this.links.add(link.absUrl("href"));
//                }
//
//            } catch (IOException ioe) {
//                // we were not successful in our HTTP request
//                System.out.println("Error in our HTTP request " + ioe);
//            }
//
//        }
//
//        public List<String> getLinks() {
//            // returns a list of all the URLs on the page
//            return this.links;
//        }
//
//
//        public void run() {
//
//            String url = nextUrl();
//            try {
//                while (true) {
//                    search(url);
//                    synchronized (url) {
//                        crawl(url);
//                    }
//
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
////    public static void main(String[] args) {
////        final int N = 5;
////        Crawler[] crawlers = new Crawler[N];
////        Object[] urls = new Object[N];
////
////        for (int i = 0; i < N; i++) {
////            urls[i] = new Object();
////        }
////
////        for (int i = 0; i < N; i++) {
////
////            crawlers[i] = new Crawler((i + 1), Crawler.pagesToVisit, );
////
////            Thread t = new Thread(crawlers[i]);
////            t.start();
////        }
////    }
//
//
//}
