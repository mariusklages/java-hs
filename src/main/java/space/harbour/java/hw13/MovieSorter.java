package space.harbour.java.hw13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieSorter {

    public static List<Movie> sortBy(Movie[] movies, Comparator<Movie> comp) {
        List<Movie> result = Arrays.asList(movies);
        result.sort(comp);
        return result;
    }


    public static List<Movie> sortByYear(Movie[] movies) {
        return sortBy(movies, (a, b) -> a.year - b.year);
    }

    public static List<Movie> sortByRuntime(Movie[] movies) {
        return sortBy(movies, (a, b) -> a.runtime - b.runtime);
    }

    public static List<Movie> sortByRating(Movie[] movies, String source) throws Exception {
        boolean test = Arrays.asList(movies).stream().allMatch(m ->
                Arrays.asList(m.ratings)
                        .stream()
                        .anyMatch(r -> r.source.equals(source)));
        if (!test)
            throw new Exception("Incorrect Source: " + source);
        return sortBy(movies, (a, b) -> {
            List<Movie.Rating> arate = Arrays.asList(a.ratings);
            List<Movie.Rating> brate = Arrays.asList(b.ratings);
            arate = arate.stream().filter(r -> r.source.equals(source)).collect(Collectors.toList());
            brate = brate.stream().filter(r -> r.source.equals(source)).collect(Collectors.toList());
            return arate.get(0).value.compareTo(brate.get(0).value);
        });
    }
    }
