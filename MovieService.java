import java.util.*;

public class MovieService {
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(String name) {
        movies.add(new Movie(name));
        System.out.println("Movie added successfully.");
    }

    public void viewMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }

        System.out.println("Movies:");
        for (Movie m : movies) {
            System.out.println("- " + m);
        }
    }

    public boolean movieExists(String name) {
        return movies.contains(new Movie(name));
    }
}