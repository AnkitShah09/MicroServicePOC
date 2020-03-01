package com.movieratings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieratings.service.MovieRatingsService;

@RestController
@RequestMapping("/movieratings")
public class MovieRatingsController {

	@Autowired
	MovieRatingsService movieRatingsService;

	@GetMapping(value = "/byName/{movieName}", produces = "application/json")
	public String getMovieRatingsByName(@PathVariable("movieName") String movieName) {
		return movieRatingsService.getMovieRatingsByName(movieName);
	}

	@GetMapping(value = "/byId/{movieId}", produces = "application/json")
	public String getMovieRatingsById(@PathVariable("movieId") Integer movieId) {
		return movieRatingsService.getMovieRatingsByMovieId(movieId);
	}
}
