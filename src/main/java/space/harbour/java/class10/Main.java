package space.harbour.java.class10;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class Main {


    public static void main(String[] args) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("java-course");

        MongoCollection collection = db.getCollection("yachts");

        MongoIterable<Document> yachts = collection.find();

        for (Document document: yachts) {
            System.out.println(document);
        }

    }
}
