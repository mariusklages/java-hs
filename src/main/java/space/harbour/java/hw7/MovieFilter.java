package space.harbour.java.hw7;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieFilter {

    public static List<Movie> filterBy(Movie[] movies, Predicate<Movie> pred) {
        List<Movie> result = Arrays.asList(movies);
        return result.stream()
                .filter(pred)
                .collect(Collectors.toList());

    }

    public static List<Movie> filterByDirector(Movie[] movies, String directorName) {
        return filterBy(movies, m -> m.director.name.equals(directorName));
    }

    public static List<Movie> filterByActor(Movie[] movies, String actorName) {
        return filterBy(movies, m -> Arrays.asList(m.actors).stream()
                .anyMatch(a -> a.name.equals(actorName)));
    }

    public static List<Movie> filterByGenre(Movie[] movies, String genre) {
        return filterBy(movies, m -> Arrays.asList(m.genres).contains(genre));
    }


}
