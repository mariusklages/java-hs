package space.harbour.java.class13;

import com.google.gson.Gson;
import spark.ModelAndView;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

//    static class Message {
//        // instead of message you could have Movie
//        public String message;
//        // public String director;
//        // public int duration;
//
//        public Message(String message) {
//            // Movie(String title)
//            this.message = message;
//            // define all the other parameters here
//        }
//    }

    static class Book {
        public String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public int pages;
        public String author;
        public Integer id;

        public Book(Integer id, String title, int pages, String author) {
            this.id = id;
            this.title = title;
            this.pages = pages;
            this.author = author;
        }
    }



    static Map<Integer, Book> books = new HashMap<>();

    public static void main(String[] args) {
        port(8008);

//        Map<String, String> users = new HashMap<>();
//        users.put("marius", "sandwich");
//        users.put("hossein", "burger");

        // http://127.0.0.1:8008/hello/Marius?user=marius&password=sandwich

        Gson gson = new Gson();

//        staticFileLocation("/public");

//        before((q, a) -> {
//            String username = q.queryParams("user");
//            String password = q.queryParams("password");
//
//            String dbPassword = users.get(username);
//
//            if (dbPassword == null || !dbPassword.equals(password)) {
//                halt(403, "Wrooooooooonggg!!!! Show the boobs or get out!");
//            }
//        });

        get("/books", (q, a) -> books.entrySet().toArray(), gson::toJson);

        get("/book/:id", (q, a) -> {
            Integer id = Integer.valueOf(q.params(":id"));
            Book book = books.get(id);

            if (book == null ) {
                halt(404);
                return null;
            }

            if (clientAcceptsHtml(q)) {
                Map<String, Object> bookMap = new HashMap<>();
                bookMap.put("title", book.title);
                bookMap.put("author", book.author);
                bookMap.put("pages", book.pages);
                return render(bookMap, "book.ftl");
            } else if (clientAcceptsJson(q))
                return gson.toJson(book);
            else halt(500);

            return null;
        });

        put("/book", (q, a) -> {
            String title = q.queryParams("title");
            String author = q.queryParams("author");
            Integer pages = Integer.valueOf(q.queryParams("pages"));
            Book book = new Book(title.hashCode(), title, pages, author);
            books.put(book.id, book);

            a.status(201);
            return book;
        }, gson::toJson);

        delete("/book/:id", (q, a) -> {
            Integer id = Integer.valueOf(q.params(":id"));
            books.remove(id);

            return null;
        });


        // to call the webpage type in 127.0.0.1:<port><path>
//        get("/hello/:name/:age", (q, a) -> {
//            Map<String, Object> values = new HashMap<>();
//            values.put("name", q.params(":name"));
//            values.put("age", 17);
//            render(values, "hello.ftl");
//            return render(values, "hello.ftl");
//                }
//            new Message("Hello " + q.params(":name")),
//            gson::toJson
//
//        );
//
//        get("/private", (q, a) -> {
//            a.status(401);
//            return "Go away!";
//        });
//
//        get("/protected", (q, a) -> {
//            halt(403, "Get the fuck out and shut up, bitch!");
//            return null;
//        });

        notFound("Custom Not Found Page");
    }


    public static String render(Map<String, Object> values, String template) {
        return new FreeMarkerEngine().render(new ModelAndView(values, template));
    }


    public static boolean clientAcceptsHtml(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("text/html");
    }

    public static boolean clientAcceptsJson(Request request) {
        String accept = request.headers("Accept");
        return accept != null && accept.contains("application/json");
    }
}
