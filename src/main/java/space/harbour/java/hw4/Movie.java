package space.harbour.java.hw4;

import space.harbour.java.class4.Jsonable;

import javax.json.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Movie implements Jsonable {

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

    public static void main(String... args) {
        ArrayList<Movie> moviesRating = new ArrayList<>(10);
        ArrayList<Movie> moviesYear = new ArrayList<>(10);
        ArrayList<Movie> moviesRuntime = new ArrayList<>(10);
        ArrayList<Movie> movies = new ArrayList<>(10);
        for (int i = 0; i < 10; ++i) {
//            moviesRating.set(i, new Movie());
//            moviesRuntime.set(i, new Movie());
//            moviesYear.set(i, new Movie());
//            // here I still need to add a description in movie
        }
        moviesRating.sort((o1, o2) -> (int) Math.floor(o1.ratings[0].getValue() - o2.ratings[0].getValue()));
        moviesYear.sort((o1, o2) -> o1.year - o2.year);
        moviesRuntime.sort((o1, o2) -> o1.runtime - o2.runtime);

        String directorName = "test";
        List<Movie> movieDirectors = movies.stream()
                .filter(movie -> movie.director.getName() == directorName)
                .collect(Collectors.toList());

        System.out.println("Movies filtered by directors: " + movieDirectors);

        String actorName = "test";
        List<Movie> movieActors = movies.stream()
                .filter(movie -> Arrays.asList(movie.actors).contains(actorName))
                .collect(Collectors.toList());
        // do I need to add a for loop for amount of actors in actors?

        System.out.println("Movies filtered by actor: " + movieActors);

        String genre = "test";
        List<Movie> movieGenres = movies.stream()
                .filter(movie -> Arrays.asList(movie.genres).contains(genre))
                .collect(Collectors.toList());

        System.out.println("Movies filtered by genre: " + movieGenres);


    }

    @Override
    public JsonObject toJsonObject() {
        return null;
    }

    @Override
    public String toJsonString() {
        return null;
    }

    @Override
    public void fromJson(String json) {

    }
}
