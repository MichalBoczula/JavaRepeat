package com.movieapp.persistance.movie;
import com.movieapp.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    List<Movie> findAllByPromotedIsTrue();
}