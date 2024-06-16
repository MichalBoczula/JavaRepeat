package com.movieapp.persistance.rating;

import com.movieapp.domain.Rating;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Long> {
    Optional<Rating> findMovieById(Long movieId);
}
