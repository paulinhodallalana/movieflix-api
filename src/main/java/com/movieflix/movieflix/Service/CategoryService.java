package com.movieflix.movieflix.Service;


import com.movieflix.movieflix.Repository.CategoryRepository;
import com.movieflix.movieflix.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

      public final CategoryRepository categoryRepository;

    //listar
    public List<Category> AllCategory(){
        return categoryRepository.findAll();
    }



    //procurar por id
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }



    //criar
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    //deletarPorId
    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }



    }

