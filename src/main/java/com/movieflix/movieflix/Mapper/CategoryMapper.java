package com.movieflix.movieflix.Mapper;


import com.movieflix.movieflix.Controller.request.CategoryRequest;
import com.movieflix.movieflix.Controller.response.CategoryResponse;
import com.movieflix.movieflix.entity.Category;
import lombok.experimental.UtilityClass;
import org.jspecify.annotations.NonNull;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(@NonNull CategoryRequest categoryRequest){
      return Category.builder()
              .name(categoryRequest.name())
              .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
