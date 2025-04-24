package com.movie.reviewapi.controller;

import com.movie.reviewapi.model.Review;
import com.movie.reviewapi.repository.MovieRepository;
import com.movie.reviewapi.repository.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    public ReviewController(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews(@RequestParam(required = false) Long movieId) {
        if (movieId != null) {
            boolean exists = movieRepository.existsById(movieId);
            if (!exists) {
                return ResponseEntity.notFound().build();
            }
            List<Review> reviews = reviewRepository.findByMovieId(movieId);
            return ResponseEntity.ok(reviews);
        }

        return ResponseEntity.ok(reviewRepository.findAll());
    }


    @PostMapping
    public ResponseEntity<Review> addReview(@RequestParam Long movieId, @Valid @RequestBody Review review) {
        return movieRepository.findById(movieId)
                .map(movie -> {
                    review.setMovie(movie);
                    return ResponseEntity.ok(reviewRepository.save(review));
                })
                .orElse(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewRepository.deleteById(id);
    }
}
