package com.moviedetailsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDetailsServiceApplication.class, args);
	}

}
