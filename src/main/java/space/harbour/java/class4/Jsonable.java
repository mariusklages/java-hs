package space.harbour.java.class4;

import javax.json.JsonObject;

public interface Jsonable {
    public JsonObject toJsonObject();
    public String toJsonString();

    void fromJson(String json);
}