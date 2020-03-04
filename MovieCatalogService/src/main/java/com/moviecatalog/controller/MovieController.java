package com.moviecatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviecatalog.service.MovieCatalogService;

@RestController
//@RequestMapping("/movie")
@RequestMapping("/")
public class MovieController {

	@Autowired
	MovieCatalogService movieCatalogService;

	@Autowired
	Environment env;

	// Upadated URL as we have added zuul api gateway so we are checking /movie at gateway level so we have
	// to remove /movie from here.
//	@GetMapping(value = "/{movieName}", produces = "application/json")
	@GetMapping(value = "{movieName}", produces = "application/json")
	public String getMovieDetailsByName(@PathVariable("movieName") String movieName) {
		System.out.println(env.getProperty("local.server.port"));
		return movieCatalogService.getCompleteMovieDetails(movieName);
	}
}
