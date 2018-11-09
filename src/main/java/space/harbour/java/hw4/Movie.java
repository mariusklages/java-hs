package space.harbour.java.hw4;

import javax.json.*;
import java.net.URL;

public class Movie {

    private String title;
    private int year;
    private String released;
    private int runtime;
    private String[] genres;
    private Director director;
    private Writer[] writers;
    private Actor[] actors;
    private String plot;
    private String[] languages;
    private String[] countries;
    private String awards;
    private URL poster;
    private Rating[] ratings;

    public Movie(JsonObject movie) {
        this.title = movie.getString("Title");
        this.year = movie.getInt("Year");
        this.released = movie.getString("Title");
        this.runtime = movie.getInt("Runtime");
        JsonArray genresArray = movie.getJsonArray("Genres");
        this.genres = new String[genresArray.size()];
        for(int i = 0; i < genresArray.size(); i++) {
            this.genres[i] = genresArray.getString(i);
        }
        //...
        JsonArray writersArray = movie.getJsonArray("Writers");
        this.writers = new Writer[writersArray.size()];
        for(int i = 0; i < writersArray.size(); i++) {
            JsonObject writerJson = writersArray.getJsonObject(i);
            writers[i] = new Writer(writerJson);
        }
        //...
        this.plot = movie.getString("Plot");
        JsonArray languagesArray = movie.getJsonArray("Languages");
        this.languages = new String[languagesArray.size()];
        for(int i = 0; i < languagesArray.size(); i++) {
            this.languages[i] = languagesArray.getString(i);
        }
        JsonArray countriesArray = movie.getJsonArray("Countries");
        this.countries = new String[countriesArray.size()];
        for(int i = 0; i < countriesArray.size(); i++) {
            this.countries[i] = countriesArray.getString(i);
        }
        this.awards = movie.getString("Awards");
        //...


    }

    public JsonObject getMovieJson() {

        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < genres.length; i++) {
            arrayBuilder.add(this.genres[i]);
        }
        JsonArray genresArray = arrayBuilder.build();

        arrayBuilder = Json.createArrayBuilder();
        for (int i = 0; i < writers.length; i++) {
            arrayBuilder.add(this.writers[i].getJson());
        }
        JsonArray writersArray = arrayBuilder.build();


        //...
        return Json.createObjectBuilder()
                .add("Title", this.title)
                .add("Year", this.year)
                .add("Released", this.released)
                //...
                .add("Genres", genresArray)
                .add("Writers", writersArray)
                //...
                .build();
    }
}
