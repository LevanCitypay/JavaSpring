package com.movie.reviewapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Schema(description = "Review entity for submitting ratings and comments")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Min(value = 1, message = "Rating must be at least 1")
    @Max(value = 5, message = "Rating must be at most 5")
    @Schema(description = "Rating between 1 and 5", example = "5")
    private int rating;

    @Size(max = 255, message = "Comment must be under 255 characters")
    @Schema(description = "User's review comment", example = "Amazing cinematography and story.")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    @Schema(hidden = true)
    private Movie movie;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie; }
}
