package com.moviecatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{movieName}")
	public String getMovieDetailsByName(@PathVariable("movieName") String movieName) {
		System.out.println("In movie catalog service");
		String movieDetails = restTemplate.getForObject("http://movie-details-service/moviedetails/asf", String.class);
		return movieDetails;
	}
}
