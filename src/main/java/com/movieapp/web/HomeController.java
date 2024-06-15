package com.movieapp.web;

import com.movieapp.persistance.movie.MovieDto;
import com.movieapp.persistance.movie.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private final MovieService movieService;

    public HomeController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<MovieDto> promotedMovies = movieService.findAllPromotedMovies();
        model.addAttribute("heading", "Promowane filmy");
        model.addAttribute("description", "Filmy polecane przez nasz zespół");
        model.addAttribute("movies", promotedMovies);
        return "movie-listing";
    }

    @GetMapping("movies/{id}")
    public String getMovie(@PathVariable long id, Model model) {
        Optional<MovieDto> optionalMovie = movieService.findMovieById(id);
        optionalMovie.ifPresent(movie -> model.addAttribute("movie", movie));
        return "movie";
    }
}