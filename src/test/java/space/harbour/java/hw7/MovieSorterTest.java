package space.harbour.java.hw7;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieSorterTest extends TestCase {

    Movie[] movies;

    @Before
    public void setUp() throws Exception {
        movies = new Movie[3];
        String[] files = {"BladeRunner.json", "Guardians.json", "Titanic.json"};
        for (int i = 0; i < 3; ++i)
            movies[i] = Movie.fromFile(files[i]);
    }

    @Test
    public void testSortByYear() {
        List<String> sorted = MovieSorter.sortByYear(movies).stream()
                .map(m -> m.title)
                .collect(Collectors.toList());
        assertEquals(sorted.get(0), "Blade Runner");
        assertEquals(sorted.get(1), "Titanic");
        assertEquals(sorted.get(2), "Guardians of the Galaxy Vol. 2");
    }

    @Test
    public void testSortByRunTime() {
        List<String> sorted = MovieSorter.sortByRuntime(movies).stream()
                .map(m -> m.title)
                .collect(Collectors.toList());
        assertEquals(sorted.get(0), "Blade Runner");
        assertEquals(sorted.get(1), "Guardians of the Galaxy Vol. 2");
        assertEquals(sorted.get(2), "Titanic");
    }

    @Test
    public void testSortByRating() {
        try {
            List<String> sorted = MovieSorter.sortByRating(movies, "Internet Movie Database").stream()
                    .map(m -> m.title)
                    .collect(Collectors.toList());
            assertEquals(sorted.get(0), "Guardians of the Galaxy Vol. 2");
            assertEquals(sorted.get(1), "Titanic");
            assertEquals(sorted.get(2), "Blade Runner");
        } catch (Exception e) {
            fail();
        }
    }


}