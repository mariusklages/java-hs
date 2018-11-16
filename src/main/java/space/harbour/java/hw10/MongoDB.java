package space.harbour.java.hw10;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import space.harbour.java.hw7.Movie;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class MongoDB {

    MongoClient mongoClient;
    MongoDatabase movieDatabase;

    MongoCollection collection;

    public MongoDB(){
        mongoClient = new MongoClient("localhost", 27017);
        movieDatabase = mongoClient.getDatabase("MovieDatabase");
        collection = movieDatabase.getCollection("movies");
    }

    public <T> T execFindQuery(BasicDBObject query, ResultHandler<T> handler) {
        FindIterable<Document> result = collection.find(query);
        T res = handler.handle(result);
        mongoClient.close();
        return res;
    }

    public MongoIterable<Document> databaseCreation(String[] files) throws Exception {
        collection.drop();
        Movie[] movies = new Movie[files.length];

        for (int i = 0; i < movies.length; ++i)
            movies[i] = Movie.fromFile(files[i]);

        for (Movie m: movies) {
            Document doc = Document.parse(m.toJsonString());
            collection.insertOne(doc);
        }

        MongoIterable<Document> moviesCollection = collection.find();

        return moviesCollection;

    }


    public FindIterable<Document> searchFunction(String key, Integer value) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(key, value);
        FindIterable<Document> result = execFindQuery(searchQuery, res -> res);
        return result;
    }




    public static void main(String[] args) {


 //       mongoClient.close(); --> where am I supposed to include the close method?

    }

}