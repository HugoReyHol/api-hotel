package com.hugo.api_hoteles.service;

import com.hugo.api_hoteles.entities.Usuario;
import com.hugo.api_hoteles.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findByNombre(String nombre) {
        var usuario = usuarioRepository.findByNombre(nombre);

        return usuario.orElse(null);

    }
}
