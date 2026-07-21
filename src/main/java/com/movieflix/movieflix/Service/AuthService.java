package com.movieflix.movieflix.Service;

import com.movieflix.movieflix.Config.TokenService;
import com.movieflix.movieflix.Controller.request.LoginRequest;
import com.movieflix.movieflix.Controller.request.UserRequest;
import com.movieflix.movieflix.Controller.response.LoginResponse;
import com.movieflix.movieflix.Controller.response.UserResponse;
import com.movieflix.movieflix.Repository.UserRepository;
import com.movieflix.movieflix.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {


    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findUserByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário ou senha inválidos"));
    }


    // CADASTRAR USUÁRIO
    public UserResponse register(UserRequest request) {

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .build();


        User savedUser = userRepository.save(user);


        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }



    // LOGIN COM JWT
    public LoginResponse login(
            LoginRequest request,
            AuthenticationManager authenticationManager
    ) {


        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )
                );


        String token = tokenService.generateToken(
                (User) authentication.getPrincipal()
        );


        return new LoginResponse(token);
    }

}