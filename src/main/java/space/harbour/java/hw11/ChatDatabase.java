package space.harbour.java.hw11;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class ChatDatabase {
    MongoClient mongoClient;
    MongoDatabase mongoDatabase;
    MongoCollection mongoCollection;

    static public final String DATABASE_NAME = "ChatDatabase";
    static public final String COLLECTION_NAME = "chats";
    static public final String USER_FIELD = "user";
    static public final String CHAT_FIELD = "chat";

    public ChatDatabase() {
        this.mongoClient = new MongoClient();
        this.mongoDatabase = mongoClient.getDatabase(DATABASE_NAME);
        this.mongoCollection = mongoDatabase.getCollection(COLLECTION_NAME);
    }

    public FindIterable<Document> getChats() {
        return mongoCollection.find();
    }

    public void addChat(String user, String chat) {
        Document toBeAdded = new Document();
        toBeAdded.put(USER_FIELD, user);
        toBeAdded.put(CHAT_FIELD, chat);

        mongoCollection.insertOne(toBeAdded);
    }
}
