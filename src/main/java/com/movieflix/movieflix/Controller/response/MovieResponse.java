package com.movieflix.movieflix.Controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(@Schema(type = "Long", description = "Código único do filme.", example = "1")
                            Long id,
                            @Schema(description = "Título do filme.", example = "Interestelar")
                            String title,
                            @Schema(description = "Descrição ou sinopse do filme.", example = "Uma equipe de exploradores viaja pelo espaço em busca de um novo lar para a humanidade.")
                            String description,
                            @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
                            @Schema(description = "Data de lançamento do filme.", example = "07/11/2014")
                            LocalDate releaseDate,
                            @Schema(description = "Nota de avaliação do filme.", example = "8.9")
                            double rating,
                            @Schema(description = "Lista de categorias do filme.")
                            List<CategoryResponse> categories,
                            @Schema(description = "Lista de plataformas de streaming onde o filme está disponível.")
                            List<StreamingResponse> streamings) {
}
