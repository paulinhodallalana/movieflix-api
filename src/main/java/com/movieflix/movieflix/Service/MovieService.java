package com.movieflix.movieflix.Service;

import com.movieflix.movieflix.Config.JWTUserDate;
import com.movieflix.movieflix.Repository.MovieRepository;
import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.entity.Movie;
import com.movieflix.movieflix.entity.Streaming;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    //listar
      public List<Movie> findAll(){
          return movieRepository.findAll();
      }

      //listar por id

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }


    public Optional<Movie> update(Long movieId, Movie updateMovie){
          Optional<Movie> optionalMovie = movieRepository.findById(movieId);

          if(optionalMovie.isPresent()){
              List<Category> categories = this.findCategory(updateMovie.getCategories());
              List<Streaming> streamings = this.findStreamings(updateMovie.getStreamings());

              JWTUserDate principal = (JWTUserDate) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


              Movie movie1 = optionalMovie.get();
              movie1.setTitle(updateMovie.getTitle());
              movie1.setDescription(updateMovie.getDescription());
              movie1.setReleaseDate(updateMovie.getReleaseDate());
              movie1.setRating(updateMovie.getRating());

              movie1.getStreamings().clear();
              movie1.getCategories().clear();

              movieRepository.save(movie1);

              return Optional.of(movie1);


          }
          return Optional.empty();

    }

    public Movie creatMovie( Movie movie){
        movie.setCategories(this.findCategory(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
          return movieRepository.save(movie);
    }

    public List<Movie> findByCategory(Long categoryId){
          return movieRepository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }


    public List<Category> findCategory(List<Category> categories){
          List<Category> categoriesFound = new ArrayList<>();
          categories.forEach(category -> {categoryService.findById(category.getId()).ifPresent(categoriesFound::add);
          });
          return categoriesFound;
          }


    public List<Streaming> findStreamings(List<Streaming> streamings){
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> {streamingService.findById(streaming.getId()).ifPresent(streamingsFound::add);
        });
        return streamingsFound;
    }


    

   public void deleteByid(Long id){
          movieRepository.deleteById(id);
   }



    }

