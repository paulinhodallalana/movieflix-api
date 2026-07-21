package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.CategoryRequest;
import com.movieflix.movieflix.Controller.response.CategoryResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryController {

    ResponseEntity<List<CategoryResponse>> findAll();

    ResponseEntity<CategoryResponse> findById(Long id);

    ResponseEntity<CategoryResponse> createCategory(CategoryRequest request);

    ResponseEntity<Void> deleteById(Long id);

}