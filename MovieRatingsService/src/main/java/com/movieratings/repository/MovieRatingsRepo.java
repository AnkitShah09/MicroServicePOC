package com.movieratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieratings.entity.MovieRating;

@Repository
public interface MovieRatingsRepo extends JpaRepository<MovieRating, Integer> {

	MovieRating findByName(String name);

}
