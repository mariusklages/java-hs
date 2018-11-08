package space.harbour.java.hw4;

import javax.json.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        File file = new File("/Users/Marius/IdeaProjects/java-harbour-test/src/space/harbour/java/hw4/BladeRunner.json");
        JsonObject json = getJsonFromFile(file);

        Movie movie = new Movie(json);
        System.out.println(movie.getMovieJson());

    }

    public static JsonObject getJsonFromFile(File file) {
        JsonObject json = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String temp;
            String string = new String();
            while ((temp = br.readLine()) != null)
                string += temp;

            JsonReader reader = Json.createReader(new StringReader(string));
            json = reader.readObject();

        } catch (IOException e) {
            System.out.println(e);
        }

        return json;
    }
}
