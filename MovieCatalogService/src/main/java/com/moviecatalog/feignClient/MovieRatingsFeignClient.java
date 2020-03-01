package com.moviecatalog.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Here name is similar as value.
@FeignClient(name = "${movie-ratings-client}")
public interface MovieRatingsFeignClient {

	@GetMapping("/byId/{movieId}")
	public String getMovieRatingsById(@PathVariable("movieId") Integer movieId);

}
