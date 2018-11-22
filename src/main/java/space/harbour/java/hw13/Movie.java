package space.harbour.java.hw13;

import javax.json.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import java.util.Set;

public class Movie implements Jsonable {

    public class Writer implements Jsonable {

        String name;
        String type;

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("Name", name);
            objectBuilder.add("Type", type);
            return objectBuilder.build();
        }

        @Override
        public String toJsonString() {
            return toJsonObject().toString();
        }

        @Override
        public void fromJson(String json) {
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jObject = reader.readObject();
            this.name = jObject.getString("Name");
            this.type = jObject.getString("Type");
        }
    }

    public class Director implements Jsonable {

        String name;

        public String getName() {
            return name;
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("Name", name);
            return objectBuilder.build();
        }

        @Override
        public String toJsonString() {
            return toJsonObject().toString();
        }

        @Override
        public void fromJson(String json) {
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jObject = reader.readObject();
            this.name = jObject.getString("Name");
        }
    }

    public class Actor implements Jsonable {

        String name;
        String as;

        public String getName() {
            return name;
        }

        public String getAs() {
            return as;
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("Name", name);
            objectBuilder.add("As", as);
            return objectBuilder.build();
        }

        @Override
        public String toJsonString() {
            return toJsonObject().toString();
        }

        @Override
        public void fromJson(String json) {
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jObject = reader.readObject();
            this.name = jObject.getString("Name");
            this.as = jObject.getString("As");
        }
    }

    public static class Rating implements Jsonable {

        String source;
        String value;
        int votes = -1;

        public String getSource() {
            return source;
        }

        public String getValue() {
            return value;
        }

        public int getVotes() {
            return votes;
        }

        @Override
        public JsonObject toJsonObject() {
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("Source", source);
            objectBuilder.add("Value", value);
            if (votes != -1)
                objectBuilder.add("Votes", votes);
            return objectBuilder.build();
        }

        @Override
        public String toJsonString() {
            return toJsonObject().toString();
        }

        @Override
        public void fromJson(String json) {
            JsonReader reader = Json.createReader(new StringReader(json));
            JsonObject jObject = reader.readObject();
            this.source = jObject.getString("Source");
            this.value = jObject.getString("Value");
            try {
                this.votes = jObject.getInt("Votes");
            } catch (Exception e) {
                // f it!
            }
        }
    }

    int         id = -1;    final String ID         = "ID";
    String      title;      final String TITLE      = "Title";
    int         year;       final String YEAR       = "Year";
    String      released;   final String RELEASED   = "Released";
    int         runtime;    final String RUNTIME    = "Runtime";
    String[]    genres;     final String GENRES     = "Genres";
    Director    director;   final String DIRECTOR   = "Director";
    Writer[]    writers;    final String WRITERS    = "Writers";
    Actor[]     actors;     final String ACTORS     = "Actors";
    String      plot;       final String PLOT       = "Plot";
    String[]    languages;  final String LANGUAGES  = "Languages";
    String[]    countries;  final String COUNTRIES  = "Countries";
    String      awards;     final String AWARDS     = "Awards";
    String      poster;     final String POSTER     = "Poster";
    Rating[]    ratings;    final String RATINGS    = "Ratings";

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void setWriters(Writer[] writers) {
        this.writers = writers;
    }

    public void setActors(Actor[] actors) {
        this.actors = actors;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setCountries(String[] countries) {
        this.countries = countries;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setRatings(Rating[] ratings) {
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getReleased() {
        return released;
    }

    public int getRuntime() {
        return runtime;
    }

    public String[] getGenres() {
        return genres;
    }

    public Director getDirector() {
        return director;
    }

    public Writer[] getWriters() {
        return writers;
    }

    public Actor[] getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String[] getLanguages() {
        return languages;
    }

    public String[] getCountries() {
        return countries;
    }

    public String getAwards() {
        return awards;
    }

    public String getPoster() {
        return poster;
    }

    public Rating[] getRatings() {
        return ratings;
    }

    public void setId(int id) {
        this.id = id;
    }

    static public JsonArray makeJsonArrayFrom(String[] arr) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (String str: arr)
            arrayBuilder.add(str);
        return arrayBuilder.build();
    }

    static public<T extends Jsonable> JsonArray makeJsonArrayFrom(T[] arr) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (T str: arr)
            arrayBuilder.add(str.toJsonObject());
        return arrayBuilder.build();
    }

    static public<T extends Jsonable> JsonArray makeJsonArrayFromList(List<T> l) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (T str: l)
            arrayBuilder.add(str.toJsonObject());
        return arrayBuilder.build();
    }

    static public JsonArray makeJsonArrayFromStringArray(String[] arr) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (String str: arr)
            arrayBuilder.add(str);
        return arrayBuilder.build();
    }

    public String[] toStringArr(JsonArray json) {
        String[] arr = new String[json.size()];
        for (int i = 0; i < json.size(); ++i)
            arr[i] = json.getString(i);
        return arr;
    }


    public static Movie fromFile(String path) throws Exception {
        Movie movie = new Movie();
        InputStream fis = new FileInputStream(path);
        JsonReader reader = Json.createReader(fis);
        String json = reader.readObject().toString();
        movie.fromJson(json);
        return movie;
    }


    @Override
    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("ID", id)
                .add("Title", title)
                .add("Year", year)
                .add("Released", released)
                .add("Runtime", runtime)
                .add("Genres", makeJsonArrayFromStringArray(genres))
                .add("Director", director.toJsonObject())
                .add("Writers", makeJsonArrayFrom(writers))
                .add("Actors", makeJsonArrayFrom(actors))
                .add("Plot", plot)
                .add("Languages", makeJsonArrayFrom(languages))
                .add("Countries", makeJsonArrayFrom(countries))
                .add("Awards", awards)
                .add("Poster", poster)
                .add("Ratings", makeJsonArrayFrom(ratings))
                .build();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }
    
    @Override
    public void fromJson(String json) {
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jObject = reader.readObject();
        Set<String> keySet = jObject.keySet();

        if (keySet.contains(TITLE))
            this.title = jObject.getString(TITLE);

        if (keySet.contains(YEAR))
            this.year = jObject.getInt(YEAR);

        if (keySet.contains(RELEASED))
            this.released = jObject.getString(RELEASED);

        if (keySet.contains(RUNTIME))
            this.runtime = jObject.getInt(RUNTIME);

        if (keySet.contains(GENRES))
            this.genres = toStringArr(jObject.getJsonArray(GENRES));

        if (keySet.contains(DIRECTOR)) {
            this.director = new Director();
            this.director.fromJson(jObject.getJsonObject(DIRECTOR).toString());
        }

        if (keySet.contains(WRITERS)) {
            JsonArray writersArr = jObject.getJsonArray(WRITERS);
            this.writers = new Writer[writersArr.size()];
            for (int i = 0; i < writersArr.size(); ++i) {
                this.writers[i] = new Writer();
                this.writers[i].fromJson(writersArr.getJsonObject(i).toString());
            }
        }

        if (keySet.contains(ACTORS)) {
            JsonArray actorsArr = jObject.getJsonArray(ACTORS);
            this.actors = new Actor[actorsArr.size()];
            for (int i = 0; i < actorsArr.size(); ++i) {
                this.actors[i] = new Actor();
                this.actors[i].fromJson(actorsArr.getJsonObject(i).toString());
            }
        }

        if (keySet.contains(PLOT))
            this.plot = jObject.getString(PLOT);

        if (keySet.contains(LANGUAGES))
            this.languages = toStringArr(jObject.getJsonArray(LANGUAGES));

        if (keySet.contains(COUNTRIES))
            this.countries = toStringArr(jObject.getJsonArray(COUNTRIES));

        if (keySet.contains(AWARDS))
            this.awards = jObject.getString(AWARDS);

        if (keySet.contains(POSTER))
            this.poster = jObject.getString(POSTER);

        if (keySet.contains(RATINGS)) {
            JsonArray ratingsArr = jObject.getJsonArray(RATINGS);
            this.ratings = new Rating[ratingsArr.size()];
            for (int i = 0; i < ratingsArr.size(); ++i) {
                this.ratings[i] = new Rating();
                this.ratings[i].fromJson(ratingsArr.getJsonObject(i).toString());
            }
        }
    }

    public static void main(String... args) {

    }
}
