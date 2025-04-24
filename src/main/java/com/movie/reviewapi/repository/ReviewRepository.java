package com.movie.reviewapi.repository;

import com.movie.reviewapi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // ✅ This import is required!

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByMovieId(Long movieId);
}
