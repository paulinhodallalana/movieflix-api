package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Controller.request.LoginRequest;

import com.movieflix.movieflix.Controller.request.UserRequest;
import com.movieflix.movieflix.Controller.response.LoginResponse;
import com.movieflix.movieflix.Controller.response.UserResponse;
import com.movieflix.movieflix.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {


    private final AuthService authService;
    private final AuthenticationManager authenticationManager;


    @Override
    public ResponseEntity<UserResponse> register(
            UserRequest request
    ){
        return ResponseEntity.ok(
                authService.register(request)
        );
    }


    @Override
    public ResponseEntity<LoginResponse> login(
            LoginRequest request
    ){
        return ResponseEntity.ok(
                authService.login(request, authenticationManager)
        );
    }

}