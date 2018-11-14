package space.harbour.java.hw7;

import javax.json.JsonObject;

public interface Jsonable {
    JsonObject toJsonObject();
    String toJsonString();
    void fromJson(String json);
}