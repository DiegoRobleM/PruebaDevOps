package com.devops.crud_usuarios.service;

import com.devops.crud_usuarios.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private List<Usuario> lista = new ArrayList<>();
    private Long contadorId = 1L;

    public List<Usuario> listar() {
        return lista;
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return lista.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    public Usuario crear(Usuario usuario) {
        usuario.setId(contadorId++);
        lista.add(usuario);
        return usuario;
    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Optional<Usuario> existente = obtenerPorId(id);

        if (existente.isPresent()) {
            Usuario u = existente.get();
            u.setNombre(usuario.getNombre());
            u.setEmail(usuario.getEmail());
            return u;
        }

        return null;
    }

    public boolean eliminar(Long id) {
        return lista.removeIf(u -> u.getId().equals(id));
    }
}
