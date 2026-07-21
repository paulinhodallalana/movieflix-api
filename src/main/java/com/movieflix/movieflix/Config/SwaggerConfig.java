package com.movieflix.movieflix.Config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme( name = "Bearer Auth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer" )
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Contact contact = new Contact()
                .name("Paulo Dalla Lana")
                .email("pd.lana@bol.com.br")
                .url("https://github.com/paulinhodallalana");


        Info info = new Info()
                .title("MovieFlix API")
                .version("1.0.0")
                .description(
                        "API para gerenciamento de filmes, categorias, streamings e usuários."
                )
                .contact(contact);


        return new OpenAPI()
                .info(info);
    }
}