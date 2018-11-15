package space.harbour.java.class9.Builder;

public class Main {

    public static void main(String[] args) {

        Movie movie = new Movie.Builder()
                .setTitle("the Girl with a Dragon Tattoo")
                .setGenre("Thiller")
                .setGenre("Adventure")
                .setGenre("Action")
                .build();

        movie.hashCode();
    }
}
