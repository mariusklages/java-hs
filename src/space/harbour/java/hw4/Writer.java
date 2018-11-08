package space.harbour.java.hw4;

import javax.json.Json;
import javax.json.JsonObject;

public class Writer extends Person {

    String type;

    public Writer(JsonObject json) {
        super(json.getString("Name"));
        this.type = json.getString("Type");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonObject getJson() {

        return Json.createObjectBuilder()
                .add("Name", this.getName())
                .add("Type", this.type)
                .build();
    }

}
