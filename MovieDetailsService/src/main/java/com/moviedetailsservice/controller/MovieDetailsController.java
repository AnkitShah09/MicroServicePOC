package com.moviedetailsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviedetailsservice.service.MovieDetailsService;

@RestController
@RequestMapping("/moviedetails")
public class MovieDetailsController {

	@Autowired
	MovieDetailsService movieDetailsService;

	@GetMapping(value = "/byName/{movieName}", produces = "application/json")
	public String getMovieDetailsByName(@PathVariable("movieName") String movieName) {
		return movieDetailsService.getMovieDetailsByMovieName(movieName);
	}

	@GetMapping(value = "/byId/{movieId}", produces = "application/json")
	public String getMovieDetailsById(@PathVariable("movieId") String movieId) {
		return movieDetailsService.getMovieDetailsByMovieId(movieId);
	}
}
