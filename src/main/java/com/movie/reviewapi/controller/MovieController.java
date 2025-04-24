package com.movie.reviewapi.controller;

import com.movie.reviewapi.model.Movie;
import com.movie.reviewapi.model.Review;
import com.movie.reviewapi.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PostMapping("/{id}/reviews")
    public Review addReview(@PathVariable Long id, @Valid @RequestBody Review review) {
        return movieService.addReview(id, review);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
