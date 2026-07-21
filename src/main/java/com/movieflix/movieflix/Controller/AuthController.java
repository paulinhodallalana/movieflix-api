package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.LoginRequest;
import com.movieflix.movieflix.Controller.request.UserRequest;
import com.movieflix.movieflix.Controller.response.LoginResponse;
import com.movieflix.movieflix.Controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Tag(
        name = "Auth",
        description = "Gerenciamento de autenticação dos usuários."
)
public interface AuthController {


    @Operation(summary = "Registrar novo usuário")
    @PostMapping("/register")
    ResponseEntity<UserResponse> register(
            @Valid @RequestBody UserRequest request
    );


    @Operation(summary = "Realizar login do usuário")
    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    );

}