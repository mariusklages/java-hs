package space.harbour.java.hw7;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class MovieFilterTest extends TestCase {

    Movie[] movies;

    @Before
    public void setUp() throws Exception {
        movies = new Movie[3];
        String[] files = {"BladeRunner.json", "Guardians.json", "Titanic.json"};
        for (int i = 0; i < 3; ++i)
            movies[i] = Movie.fromFile(files[i]);
    }


    @Test
    public void testFilterByDirector() {
        List<String> filtered = MovieFilter.filterByDirector(movies, "James Gunn").stream()
                .map(m -> m.title)
                .collect(Collectors.toList());
        assertEquals(filtered.get(0), "Guardians");
        assertEquals(filtered.size(), 1);
    }

    @Test
    public void testFilterByActor() {
        List<String> filtered = MovieFilter.filterByActor(movies, "Leonardo DiCaprio").stream()
                .map(m -> m.title)
                .collect(Collectors.toList());
        assertEquals(filtered.get(0), "Titanic");
        assertEquals(filtered.size(), 1);
    }

    @Test
    public void testFilterByGenre() {
        List<String> filtered = MovieFilter.filterByGenre(movies, "Thriller").stream()
                .map(m -> m.title)
                .collect(Collectors.toList());
        assertEquals(filtered.size(), 1);
        assertTrue(filtered.contains("BladeRunner"));
    }
}

