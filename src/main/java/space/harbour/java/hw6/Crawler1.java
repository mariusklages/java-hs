//package space.harbour.java.hw6;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.*;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//class Crawler1 implements Runnable {
//
//    private HashSet<URL> visited;
//    private Queue<URL> toVisit;
//    private final int nThread = 10;
//    private URL url;
//    ExecutorService executor;
//    final static Pattern urlPat = Pattern.compile("(https|http)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
//
//    public Crawler1(){
//        toVisit = new LinkedList<>();
//        visited = new HashSet<>();
//        executor = Executors.newFixedThreadPool(nThread);
//    }
//
//    public LinkedList<URL> getPageLinks(String content) throws IOException {
//        LinkedList<URL> urls = new LinkedList<>();
//        String[] lines = content.split(System.getProperty("line.separator"));
//        for(String line: lines){
//            Matcher m = urlPat.matcher(line);
//            while(m.find()) {
//                try{
//                    URL new_url = new URL(m.group(0));
//                    urls.add(new_url);
//                } catch (MalformedURLException e){}
//            }
//        }
//        return urls;
//    }
//
//    @Override
//    public void run(){
//        while(!this.toVisit.isEmpty()) {
//            synchronized (this.visited) {
//                if (!this.visited.contains(this.url)) {
//                    this.visited.add(this.url);
//                    try {
//                        List<URL> newUrls = getPageLinks(getContentOfWebPage(this.url));
//                        for (URL url_new : newUrls) {
//                            if (!this.toVisit.contains(url_new)) {
//                                this.toVisit.add(url_new);
//                                this.toVisit.remove(this.url);
//                            }
//                        }
//                    } catch (IOException e) {
//                        System.out.println("Error while parsing: " + e);
//                    }
//                }
//            }
//        }
//
//    }
//
//    public String getContentOfWebPage(URL url) {
//        final StringBuilder content = new StringBuilder();
//        try (InputStream is = url.openConnection().getInputStream();
//             InputStreamReader in = new InputStreamReader(is, "UTF-8");
//             BufferedReader br = new BufferedReader(in); ) {
//            String inputLine;
//            while ((inputLine = br.readLine()) != null)
//                content.append(inputLine);
//        } catch (IOException e) {
//            System.out.println("Failed to retrieve content of " + url.toString());
//            e.printStackTrace();
//        }
//
//        return content.toString();
//    }
//
//    public HashSet<URL> getVisited(){
//        synchronized (visited) {
//            return visited;
//        }
//    }
//
//    public ExecutorService getExecutor() {
//        return executor;
//    }
//
//
//    public void runCrawler(){
//        for(int i=0; i<nThread; i++){
//            executor.submit(this);
//        }
//        executor.shutdown();
//    }
//
//    public void setQueue(Queue<URL> queue) {
//        toVisit = queue;
//    }
//}