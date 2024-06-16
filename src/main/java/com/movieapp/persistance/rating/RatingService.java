package com.movieapp.persistance.rating;

import com.movieapp.domain.*;
import org.springframework.stereotype.Service;
import com.movieapp.persistance.movie.*;


@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final MovieRepository movieRepository;

    public RatingService(RatingRepository ratingRepository, MovieRepository movieRepository) {
        this.ratingRepository = ratingRepository;
        this.movieRepository = movieRepository;
    }

    public void addOrUpdateRating(long movieId, int rating) {
        Rating ratingToSaveOrUpdate = ratingRepository.findMovieById(movieId)
                .orElseGet(Rating::new);
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        ratingToSaveOrUpdate.setMovie(movie);
        ratingToSaveOrUpdate.setRating(rating);
        ratingRepository.save(ratingToSaveOrUpdate);
    }
}