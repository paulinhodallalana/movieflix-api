package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.MovieRequest;
import com.movieflix.movieflix.Controller.response.MovieResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieController {




        ResponseEntity<MovieResponse> save(MovieRequest movieRequest);

        ResponseEntity<List<MovieResponse>> findAll();

        ResponseEntity<MovieResponse> findById(Long id);

        ResponseEntity<MovieResponse> update(Long id, MovieRequest movieRequest);

        ResponseEntity<List<MovieResponse>> findByCategory(Long category);

        ResponseEntity<Void> delete(Long id);

    }

