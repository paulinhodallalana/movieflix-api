package com.movieflix.movieflix.Controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponse(

        @Schema(
                type = "Long",
                description = "Código identificador do usuário"
        )
        Long id,


        @Schema(
                type = "String",
                description = "Nome do usuário"
        )
        String name,


        @Schema(
                type = "String",
                description = "Email do usuário"
        )
        String email

) {
}