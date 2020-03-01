package com.moviedetailsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviedetailsservice.entity.MovieDetail;

@Repository
public interface MovieDetailsRepo extends JpaRepository<MovieDetail, Integer> {
	MovieDetail findByName(String name);
}
