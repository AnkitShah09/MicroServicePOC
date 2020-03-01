package com.moviecatalog.serviceImpl;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviecatalog.entity.Movie;
import com.moviecatalog.model.MovieDTO;
import com.moviecatalog.repo.MovieCatalogRepo;
import com.moviecatalog.service.MovieCatalogService;

@Service
public class MovieCatalogServiceImpl implements MovieCatalogService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	MovieCatalogRepo movieCatalogRepo;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public String getCompleteMovieDetails(String movieName) {
		Movie movie = movieCatalogRepo.findByName(movieName);
		if (movie == null) {
			String errorMessage = "No movie found with name:" + movieName;
			return errorMessage;
		}
		Integer movieDetailsId = movie.getMovieDetailsId();
		Integer movieRatingsId = movie.getMovieRatingsId();
		LinkedHashMap movieDetails = restTemplate
				.getForObject("http://movie-details-service/moviedetails/byId/" + movieDetailsId, LinkedHashMap.class);
		String movieDescription = movieDetails.get("description").toString();
		LinkedHashMap movieRatings = restTemplate
				.getForObject("http://movie-ratings-service/movieratings/byId/" + movieRatingsId, LinkedHashMap.class);
		String movieRating = movieRatings.get("ratings").toString();
		MovieDTO movieDTO = new MovieDTO(movieName, movieDescription, movieRating);
		try {
			return objectMapper.writeValueAsString(movieDTO);
		} catch (JsonProcessingException e) {
			return e.getLocalizedMessage();
		}
	}

}