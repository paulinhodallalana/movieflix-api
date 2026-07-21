package com.movieflix.movieflix.Mapper;

import com.movieflix.movieflix.Controller.request.MovieRequest;
import com.movieflix.movieflix.Controller.request.StreamingRequest;
import com.movieflix.movieflix.Controller.response.CategoryResponse;
import com.movieflix.movieflix.Controller.response.MovieResponse;
import com.movieflix.movieflix.Controller.response.StreamingResponse;
import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.entity.Movie;
import com.movieflix.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

      public static Movie toMovie(MovieRequest movieRequest){

          List<Category> categories = movieRequest.categories().stream()
                  .map(categoryId -> Category.builder()
                          .id(categoryId)
                          .build())
                  .toList();

          List<Streaming> streamings = movieRequest.streamings().stream()
                  .map(streamingId -> {
                      return Streaming.builder()
                              .id(streamingId)
                              .build();
                  })
                  .toList();


          return Movie.builder()
                  .title(movieRequest.title())
                  .description(movieRequest.description())
                  .releaseDate(movieRequest.releaseDate())
                  .rating(movieRequest.rating())
                  .categories(categories)
                  .streamings(streamings)
                  .build();

      }

     public static MovieResponse toMovieResponse(Movie movie){


         List<CategoryResponse> categories = movie.getCategories()
                  .stream()
                  .map(CategoryMapper::toCategoryResponse)
                  .toList();

         List<StreamingResponse> streamings = movie.getStreamings()
                 .stream()
                 .map(StreamingMapper::toStreamingResponse)
                 .toList();

          return MovieResponse.builder()
                  .id(movie.getId())
                  .title(movie.getTitle())
                  .description(movie.getDescription())
                  .releaseDate(movie.getReleaseDate())
                  .rating(movie.getRating())
                  .streamings(streamings)
                  .categories(categories)
                  .build();

     }


}
