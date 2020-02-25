package com.moviecatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	@GetMapping("/movie/{movieName}")
	public void getMovieDetailsByName(@PathVariable("movieName")String movieName) {
		System.out.println("In movie catalog service");
	}
}
