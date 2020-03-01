package com.movieratings.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieratings.entity.MovieRating;
import com.movieratings.repository.MovieRatingsRepo;
import com.movieratings.service.MovieRatingsService;

@Service
public class MovieRatingsServiceImpl implements MovieRatingsService {

	@Autowired
	MovieRatingsRepo movieRatingsRepo;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public String getMovieRatingsByName(String movieName) {
		try {
			return objectMapper.writeValueAsString(movieRatingsRepo.findByName(movieName));
		} catch (JsonProcessingException e) {
			String errorMessage = e.getLocalizedMessage();
			return errorMessage;
		}
	}

	@Override
	public String getMovieRatingsByMovieId(String movieId) {
		String errorMessage;
		Optional<MovieRating> movie = movieRatingsRepo.findById(Integer.parseInt(movieId));
		if (movie.isPresent()) {
			try {
				return objectMapper.writeValueAsString(movie);
			} catch (JsonProcessingException e) {
				errorMessage = e.getLocalizedMessage();
				return errorMessage;
			}
		}
		errorMessage = "Movie ratings of Id:" + movieId + " is not present id Database.";
		return errorMessage;
	}

}
