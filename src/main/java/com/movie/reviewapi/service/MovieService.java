package com.movie.reviewapi.service;

import com.movie.reviewapi.model.Movie;
import com.movie.reviewapi.repository.MovieRepository;
import com.movie.reviewapi.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ReviewRepository reviewRepository;

    public MovieService(MovieRepository movieRepository, ReviewRepository reviewRepository) {
        this.movieRepository = movieRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public boolean movieExistsByTitle(String title) {
        return movieRepository.existsByTitleIgnoreCase(title);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
