package com.hugo.api_hoteles;

import com.hugo.api_hoteles.security.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
public class ApiHotelesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiHotelesApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    public class SecurityConfig {
        @Bean
        public
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf().disable() // Deshabilita CSRF (solo si es necesario)
                .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.POST, "/user").permitAll() // Permite accesos a "/user"
                    .requestMatchers("/doc/swagger-ui/**").permitAll() // Permite accesos a interfaz grafica swagger
                    .requestMatchers("/v3/api-docs/**").permitAll() // Permite accesos a informacion swagger
                    .requestMatchers(HttpMethod.GET, "/api/hotel/localidad/**").permitAll() // Permite accesos a hoteles por localidad
                    .requestMatchers(HttpMethod.GET, "/api/hotel/categoria/**").permitAll() // Permite accesos a hoteles por categoria
                    .requestMatchers(HttpMethod.GET, "/api/habitacion/**").permitAll() // Permite accesos a busqueda de habitaciones
                    .anyRequest().authenticated() // Todo lo demás requiere autenticación
                );
            return http.build(); } }
        }
