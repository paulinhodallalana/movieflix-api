package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.MovieRequest;
import com.movieflix.movieflix.Controller.response.MovieResponse;
import com.movieflix.movieflix.Mapper.MovieMapper;
import com.movieflix.movieflix.Service.MovieService;
import com.movieflix.movieflix.entity.Movie;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/movieflix/movie")
@Tag(name = "Movie", description = "Recurso responsável pelo gerenciamento dos filmes.")
public class MovieControllerImpl implements MovieController {

    private final MovieService movieService;


    @Operation(summary = "Salvar filme", description = "Cadastra um novo filme no sistema.",
            security = @SecurityRequirement(name = "Bearer Auth"))
    @ApiResponse(responseCode = "201", description = "Filme salvo com sucesso",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = MovieResponse.class))
    )
    @PostMapping
    @Override
    public ResponseEntity<MovieResponse> save(
            @Valid @RequestBody MovieRequest movieRequest) {

        Movie movie = MovieMapper.toMovie(movieRequest);

        Movie savedMovie = movieService.creatMovie(movie);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(MovieMapper.toMovieResponse(savedMovie));
    }


    @Operation(summary = "Listar filmes", description = "Retorna todos os filmes cadastrados.")
    @GetMapping
    @Override
    public ResponseEntity<List<MovieResponse>> findAll() {

        return ResponseEntity.ok(
                movieService.findAll()
                        .stream()
                        .map(MovieMapper::toMovieResponse)
                        .toList()
        );
    }


    @Operation(summary = "Buscar filme por ID", description = "Busca um filme pelo identificador."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Filme encontrado"
            ),
            @ApiResponse(responseCode = "404", description = "Filme não encontrado"
            )
    })
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<MovieResponse> findById(
            @PathVariable Long id) {

        return movieService.findById(id)
                .map(movie ->
                        ResponseEntity.ok(
                                MovieMapper.toMovieResponse(movie)
                        )
                )
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Atualizar filme", description = "Atualiza um filme existente.", security = @SecurityRequirement(name = "Bearer Auth"))
    @PutMapping("/{id}")
    @Override
    public ResponseEntity<MovieResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody MovieRequest movieRequest) {

        return movieService.update(
                        id,
                        MovieMapper.toMovie(movieRequest)
                )
                .map(movie ->
                        ResponseEntity.ok(
                                MovieMapper.toMovieResponse(movie)
                        )
                )
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Buscar filmes por categoria", description = "Retorna filmes de uma categoria.")
    @GetMapping("/search")
    @Override
    public ResponseEntity<List<MovieResponse>> findByCategory(
            @RequestParam Long category) {

        return ResponseEntity.ok(
                movieService.findByCategory(category)
                        .stream()
                        .map(MovieMapper::toMovieResponse)
                        .toList()
        );
    }


    @Operation(summary = "Excluir filme", description = "Remove um filme pelo ID.")
    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {
        Optional<Movie> movie = movieService.findById(id);
        if(movie.isPresent()) {
            movieService.deleteByid(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}