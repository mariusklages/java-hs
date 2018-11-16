package space.harbour.java.hw10;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoIterable;
import junit.framework.TestCase;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

public class MongoDBTest extends TestCase {

    String[] files = {"./BladeRunner.json",
            "./Guardians.json",
            "./Titanic.json"};

    MongoDB movieDatabase = new MongoDB();

    @Override
    public void setUp() throws Exception {
        MongoIterable<Document> collection =  movieDatabase.databaseCreation(files);
    }

    public void testDatabaseCreation() throws Exception {
        MongoDB movieDatabase = new MongoDB();

        MongoIterable<Document> collection =  movieDatabase.databaseCreation(files);
        for (Document document: collection) {
            System.out.println(document);
        }

        assertEquals((Integer)1982, collection.first().getInteger("Year"));
        // how should we test this???

    }

    public void testSearchFunction() {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Year", 1982);

        String title = movieDatabase.execFindQuery(searchQuery, result -> {
            for (Document document: result) {
                System.out.println(document);
            }
            return result.first().getString("Title");
        });


        assertEquals("Blade Runner", title);

    }
}