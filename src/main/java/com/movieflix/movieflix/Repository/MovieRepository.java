package com.movieflix.movieflix.Repository;

import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findMovieByCategories(List<Category> categories);


}
