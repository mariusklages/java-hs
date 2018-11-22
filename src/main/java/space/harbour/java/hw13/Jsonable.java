package space.harbour.java.hw13;

import javax.json.JsonObject;

public interface Jsonable {
    JsonObject toJsonObject();
    String toJsonString();
    void fromJson(String json);
}