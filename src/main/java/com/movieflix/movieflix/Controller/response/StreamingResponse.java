package com.movieflix.movieflix.Controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record StreamingResponse(

        @Schema(
                type = "Long",
                description = "Código identificador do serviço de streaming"
        )
        Long id,


        @Schema(
                type = "String",
                description = "Nome do serviço de streaming"
        )
        String name

) {
}