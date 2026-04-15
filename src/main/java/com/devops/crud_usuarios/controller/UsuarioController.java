package com.devops.crud_usuarios.controller;

import com.devops.crud_usuarios.model.Usuario;
import com.devops.crud_usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador REST para gestionar las operaciones CRUD de usuarios.
 * Expone los endpoints bajo la ruta base /usuarios.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Servicio que contiene la lógica de negocio para usuarios
    private final UsuarioService usuarioService;

    /**
     * Constructor con inyección de dependencia del servicio de usuarios.
     *
     * @param usuarioService servicio que gestiona la lógica de usuarios
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * GET /usuarios
     * Retorna la lista completa de todos los usuarios registrados.
     *
     * @return lista de objetos Usuario
     */
    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    /**
     * GET /usuarios/{id}
     * Busca y retorna un usuario por su ID.
     * Retorna Optional vacío si no se encuentra.
     *
     * @param id identificador único del usuario
     * @return Optional con el usuario encontrado, o vacío si no existe
     */
    @GetMapping("/{id}")
    public Optional<Usuario> obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    /**
     * POST /usuarios
     * Crea un nuevo usuario con los datos recibidos en el cuerpo de la petición.
     *
     * @param usuario objeto Usuario con los datos a registrar
     * @return el Usuario creado
     */
    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.crear(usuario);
    }

    /**
     * PUT /usuarios/{id}
     * Actualiza los datos de un usuario existente según su ID.
     *
     * @param id      identificador del usuario a actualizar
     * @param usuario objeto Usuario con los nuevos datos
     * @return el Usuario actualizado
     */
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizar(id, usuario);
    }

    /**
     * DELETE /usuarios/{id}
     * Elimina un usuario según su ID.
     *
     * @param id identificador del usuario a eliminar
     * @return true si fue eliminado correctamente, false si no se encontró
     */
    @DeleteMapping("/{id}")
    public boolean eliminar(@PathVariable Long id) {
        return usuarioService.eliminar(id);
    }
}
