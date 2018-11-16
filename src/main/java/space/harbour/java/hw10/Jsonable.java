package space.harbour.java.hw10;

import javax.json.JsonObject;

public interface Jsonable {
    JsonObject toJsonObject();
    String toJsonString();
    void fromJson(String json);
}