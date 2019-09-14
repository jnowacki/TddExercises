package pl.jnowacki.hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import pl.jnowacki.model.Movie;

import java.util.List;

public class AwardedMoviesMatcher extends TypeSafeMatcher<List<Movie>> {

    public static AwardedMoviesMatcher hasOnlyAwardedMovies() {
        return new AwardedMoviesMatcher();
    }

    @Override
    protected boolean matchesSafely(List<Movie> movies) {
        return movies.stream().noneMatch(movie -> movie.getAwards().isEmpty());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has at least 1 award");
    }
}

