package com.movieflix.movieflix.Controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(

        @Schema(
                type = "String",
                description = "Nome da categoria do filme"
        )
        @NotEmpty(message = "Nome da categoria é obrigatório")
        String name

) {

}