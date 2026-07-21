package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.CategoryRequest;
import com.movieflix.movieflix.Controller.response.CategoryResponse;
import com.movieflix.movieflix.Mapper.CategoryMapper;
import com.movieflix.movieflix.Service.CategoryService;
import com.movieflix.movieflix.entity.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@AllArgsConstructor
@Tag(name = "Category", description = "Gerenciamento das categorias dos filmes.")
public class CategoryControllerImpl implements CategoryController {


    private final CategoryService categoryService;


    // Listar todas as categorias
    @Operation(
            summary = "Listar categorias",
            description = "Retorna todas as categorias cadastradas."
    )
    @GetMapping
    @Override
    public ResponseEntity<List<CategoryResponse>> findAll() {

        List<CategoryResponse> categories =
                categoryService.AllCategory()
                        .stream()
                        .map(CategoryMapper::toCategoryResponse)
                        .toList();

        return ResponseEntity.ok(categories);
    }


    // Buscar categoria por ID
    @Operation(
            summary = "Buscar categoria por ID",
            description = "Retorna uma categoria pelo identificador."
    )
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CategoryResponse> findById(
            @PathVariable Long id) {

        return categoryService.findById(id)
                .map(category ->
                        ResponseEntity.ok(
                                CategoryMapper.toCategoryResponse(category)
                        )
                )
                .orElse(ResponseEntity.notFound().build());
    }


    // Criar categoria
    @Operation(
            summary = "Criar categoria",
            description = "Cadastra uma nova categoria."
    )
    @PostMapping
    @Override
    public ResponseEntity<CategoryResponse> createCategory(
            @Valid @RequestBody CategoryRequest request) {

        Category category = CategoryMapper.toCategory(request);

        Category savedCategory =
                categoryService.createCategory(category);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CategoryMapper.toCategoryResponse(savedCategory));
    }


    // Deletar categoria
    @Operation(
            summary = "Excluir categoria",
            description = "Remove uma categoria pelo ID."
    )
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {

        categoryService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}