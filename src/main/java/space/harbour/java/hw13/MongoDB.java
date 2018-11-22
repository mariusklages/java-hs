package space.harbour.java.hw13;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

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
        FindIterable<Document> result;
        if (query != null)
            result = collection.find(query);
        else
            result = collection.find();

        T res = handler.handle(result);
//        mongoClient.close();
        return res;
    }

    public Movie findMovieByID(int id) {
        BasicDBObject query = new BasicDBObject();
        query.append("ID", id);
        Document doc = execFindQuery(query, result -> result.first());

        Movie movie = new Movie();
        try {
            movie.fromJson(doc.toJson());
            movie.setId(doc.getInteger("ID"));
        } catch (Exception e) {
            return null;
        }
       return movie;
    }

    public void removeMovieByID(int id) {
        BasicDBObject query = new BasicDBObject();
        query.append("ID", id);
        collection.deleteOne(query);
    }

    public void replaceMovieByID(int id, Movie movie) {
        BasicDBObject query = new BasicDBObject();
        query.append("ID", id);
        Document doc = Document.parse(movie.toJsonString());
        collection.replaceOne(query, doc);
    }

    public void execAddQuery(Movie movie) {
        Document doc = Document.parse(movie.toJsonString());
        collection.insertOne(doc);
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