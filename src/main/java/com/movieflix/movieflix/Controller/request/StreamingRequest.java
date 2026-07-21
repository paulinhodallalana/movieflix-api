package com.movieflix.movieflix.Controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(

        @Schema(
                type = "String",
                description = "Nome do serviço de streaming"
        )
        @NotEmpty(message = "Nome do serviço é obrigatorio")
        String name

) {

}