# MicroServicePOC
This repository is a small POC on MicroService.
There are 3 micro services in this project.
1) movie-catalog-service
  -> This service is the main entry point of the project.
  -> You can get all movie details like description,ratings from this service just by calling API endpoints.
  -> This micro-service uses 2 more micro-services to fulfill its work.
    (1) movie-ratings-service
    (2) movie-details-service
2) movie-ratings-service
  -> This micro-service gives movie ratings from movie name.
3) movie-details-service
  -> This micro-service gives movie details like movie description from movie name.
