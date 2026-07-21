package com.movieflix.movieflix.Controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movieflix.movieflix.entity.Movie;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record MovieRequest(@Schema(type = "String",description = "Nome do filme ")
                           @NotEmpty(message = "Título do filme é obrigatorio")String title,
                           @Schema(type = "String",description = "Descrição do filme ")
                           String description,

                           @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
                           @Schema(type = "Date",description = "Data de lançamento do filme ")
                           LocalDate releaseDate,
                           @Schema(type = "double",description = "Score do filme ")
                           double rating,
                           @Schema(type = "Array",description = "Lista de codigo de categoria ")
                           List<Long> categories,
                           @Schema(type = "Array",description = "Lista de codigos de serviços de streming")
                           List<Long> streamings
                           ) {

}
