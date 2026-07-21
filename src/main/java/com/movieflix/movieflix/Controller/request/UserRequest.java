package com.movieflix.movieflix.Controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record UserRequest(

        @Schema(
                type = "String",
                description = "Nome completo do usuário"
        )
        @NotEmpty(message = "Nome é obrigatório")
        String name,


        @Schema(
                type = "String",
                description = "Email do usuário"
        )
        @NotEmpty(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,


        @Schema(
                type = "String",
                description = "Senha de acesso do usuário"
        )
        @NotEmpty(message = "Senha é obrigatória")
        String password

) {
}