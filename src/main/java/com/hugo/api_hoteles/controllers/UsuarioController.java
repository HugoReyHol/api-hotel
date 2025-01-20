package com.hugo.api_hoteles.controllers;

import com.hugo.api_hoteles.dao.UsuarioDAO;
import com.hugo.api_hoteles.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    @PostMapping("user")
    public Usuario login(@RequestParam("nombre") String nombre, @RequestParam("contrasena") String contrasena) {
        Usuario usuario = UsuarioDAO.obtener(nombre);

        if (Objects.equals(usuario.getContrasena(), contrasena)) {
            System.out.println("Me crea el token");
            String token = getJWTToken(nombre);

            usuario.setToken(token);

        } else {
            usuario = null;
        }

        return usuario;
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
