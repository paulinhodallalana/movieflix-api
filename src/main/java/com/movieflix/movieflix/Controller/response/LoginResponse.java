package com.movieflix.movieflix.Controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(

        @Schema(
                type = "String",
                description = "Token JWT de autenticação do usuário"
        )
        String token

) {
}