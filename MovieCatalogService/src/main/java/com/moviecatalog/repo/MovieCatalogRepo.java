package com.moviecatalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moviecatalog.entity.Movie;

@Repository
public interface MovieCatalogRepo extends JpaRepository<Movie, Integer> {

	Movie findByName(String name);

}
