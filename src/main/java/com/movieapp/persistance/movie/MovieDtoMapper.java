package com.movieapp.persistance.movie;

import com.movieapp.domain.Movie;

public class MovieDtoMapper {
    static MovieDto map(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getOriginalTitle(),
                movie.getReleaseYear(),
                movie.getGenre().getName(),
                movie.isPromoted()
        );
    }
}