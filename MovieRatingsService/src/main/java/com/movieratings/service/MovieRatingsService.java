package com.movieratings.service;

public interface MovieRatingsService {

	public String getMovieRatingsByName(String movieName);

	public String getMovieRatingsByMovieId(Integer movieId);
}
