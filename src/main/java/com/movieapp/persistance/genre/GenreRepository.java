package com.movieapp.persistance.genre;

import com.movieapp.domain.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

interface GenreRepository extends CrudRepository<Genre, Long> {
    Optional<Genre> findByNameIgnoreCase(String name);
}