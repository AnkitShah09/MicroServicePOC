package com.moviecatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalog.service.MovieCatalogService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	@Autowired
	MovieCatalogService movieCatalogService;

	@GetMapping(value = "/{movieName}",produces = "application/json")
	public String getMovieDetailsByName(@PathVariable("movieName") String movieName) {
		return movieCatalogService.getCompleteMovieDetails(movieName);
	}
}
