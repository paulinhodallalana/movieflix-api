package com.movieflix.movieflix.Controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(

        @Schema(
                type = "String",
                description = "Email cadastrado do usuário"
        )
        @NotEmpty(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,


        @Schema(
                type = "String",
                description = "Senha do usuário"
        )
        @NotEmpty(message = "Senha é obrigatória")
        String password

) {
}