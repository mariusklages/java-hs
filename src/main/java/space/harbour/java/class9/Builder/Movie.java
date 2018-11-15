package space.harbour.java.class9.Builder;

import java.util.*;

public class Movie {

    private String title;
    private int year;
    private int runningTime;
    private String[] genres;
    private String[] actors;

    static class Builder {
        private static final int CURRENT_YEAR = 2018;
        private static final int DEFAULT_TIME = 90;

        private String title;
        private int year = CURRENT_YEAR;
        private int runningTime = DEFAULT_TIME;
        private boolean goodForChildren = false;
        private List<String> genres = new LinkedList<>();
        private List<String> actors = new LinkedList<>();

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setGenre(String genre) {
            genres.add(genre);
            return this;
        }

        public Movie build() {
            if (title == null || title.isEmpty())
                throw new IllegalArgumentException();

            if (genres.contains("Horror") && goodForChildren)
                throw new IllegalArgumentException();

            return new Movie(title, year, runningTime,
                    genres.toArray(new String[genres.size()]),
                    actors.toArray(new String[actors.size()]));
        }


    }


    private Movie(String title, int year, int runningTime, String[] genres, String[] actors) {
        this.title = title;
        this.year = year;
        this.runningTime = runningTime;
        this.genres = genres;
        this.actors = actors;
    }
}
