package space.harbour.java.hw13;

import com.mongodb.client.FindIterable;
import org.bson.Document;

public interface ResultHandler<T> {
    T handle(FindIterable<Document> result);
}
