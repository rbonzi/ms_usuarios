package com.Usuario.usuario.controller;


import com.Usuario.usuario.dto.UsuarioRequestDTO;
import com.Usuario.usuario.dto.UsuarioResponseDTO;
import com.Usuario.usuario.model.Usuario;
import com.Usuario.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gym/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/idsearch/{idUsuario}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long idUsuario){
        return usuarioService.obtenerPorId(idUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario){
        Usuario nuevo = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/updateuser/{idUsuario}")
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(
            @PathVariable Long idUsuario,
            @Valid @RequestBody UsuarioRequestDTO dto){
    return usuarioService.registrarUsuario(idUsuario, dto)


    @DeleteMapping("/deleteuser/{idUsuario}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable Long idUsuario){
        if(usuarioService.obtenerPorId(idUsuario).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}

