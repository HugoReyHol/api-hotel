package com.hugo.api_hoteles.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("API Hoteles")
                        .description("API REST para gestionar hoteles")
                        .contact(new Contact()
                                .name("Hugo")
                                .email("hugo.reyhol@educa.jcyl.es"))
                        .version("1.0"));
    }

}