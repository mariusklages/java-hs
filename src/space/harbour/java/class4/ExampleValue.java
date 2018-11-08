package space.harbour.java.class4;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class ExampleValue implements Jsonable {
    public Integer i = 10;
    private String s = "ABC";
    protected float f = .9f;
    private InsideClass hiddenClass = new InsideClass();

    class InsideClass implements Jsonable{
        String s = "XYZ";
        Integer i = 1050;

        @Override
        public JsonObject toJsonObject() {
            return Json.createObjectBuilder()
                    .add("i", i)
                    .add("s", s)
                    .build();
        }

        @Override
        public String toJsonString(){
            return toJsonObject().toString();
        }

        @Override
        public void fromJson(String json) {
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject object = reader.readObject();
            reader.close();
            this.s = object.getString("s");
            this.i = object.getInt("i");
        }


    }

    @Override
    public JsonObject toJsonObject(){
        return Json.createObjectBuilder()
                .add("i", i)
                .add("s", s)
                .add("f", f)
                .add("hiddenClass", hiddenClass.toJsonObject())
                .build();
    }

    @Override
    public String toJsonString(){
        return toJsonObject().toString();
    }

    @Override
    public void fromJson(String json) {
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject object = reader.readObject();
        reader.close();
        this.s = object.getString("s");
        this.i = object.getInt("i");
        this.f = (float) object.getJsonNumber("f").doubleValue();

        this.hiddenClass = new InsideClass();
        this.hiddenClass.fromJson(object.getJsonObject("hiddenClass").toString());
    }
}