package space.harbour.java.class4;

import javax.json.JsonObject;

public interface Jsonable {
    JsonObject toJsonObject();
    String toJsonString();
    void fromJson(String json);
}