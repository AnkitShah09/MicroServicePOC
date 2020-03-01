package com.moviecatalog.model;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

	@NotBlank
	@NotNull
	public String movieName;

	@NotBlank
	@NotNull
	public String movieDescription;

	@NotBlank
	@NotNull
	public String movieRatings;
}
