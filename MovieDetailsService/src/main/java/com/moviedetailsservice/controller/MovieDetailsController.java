package com.moviedetailsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviedetails")
public class MovieDetailsController {

	@GetMapping("/{movieName}")
	public String getMovieDetailsByName(@PathVariable("movieName")String movieName) {
		return "This is sample text";
	}
	
}
