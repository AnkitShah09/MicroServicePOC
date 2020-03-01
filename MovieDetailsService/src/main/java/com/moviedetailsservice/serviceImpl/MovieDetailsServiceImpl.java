package com.moviedetailsservice.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviedetailsservice.entity.MovieDetail;
import com.moviedetailsservice.repository.MovieDetailsRepo;
import com.moviedetailsservice.service.MovieDetailsService;

@Service
public class MovieDetailsServiceImpl implements MovieDetailsService {

	@Autowired
	MovieDetailsRepo movieDetailsRepo;

	@Autowired
	ObjectMapper objectMapper;

	@Override
	public String getMovieDetailsByMovieName(String movieName) {
		MovieDetail movie = movieDetailsRepo.findByName(movieName);
		try {
			return objectMapper.writeValueAsString(movie);
		} catch (JsonProcessingException e) {
			String errorMessage = e.getLocalizedMessage();
			return errorMessage;
		}
	}

	@Override
	public String getMovieDetailsByMovieId(String movieId) {
		String errorMessage;
		Optional<MovieDetail> movie = movieDetailsRepo.findById(Integer.parseInt(movieId));
		if (movie.isPresent()) {
			try {
				return objectMapper.writeValueAsString(movie);
			} catch (JsonProcessingException e) {
				errorMessage = e.getLocalizedMessage();
				return errorMessage;
			}
		}
		errorMessage = "Movie description of Id:" + movieId + " is not present id Database.";
		return errorMessage;
	}

}
