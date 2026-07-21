package com.movieflix.movieflix.Config;


import lombok.Builder;

@Builder
public record JWTUserDate(Long id, String name,String email ) {
}
