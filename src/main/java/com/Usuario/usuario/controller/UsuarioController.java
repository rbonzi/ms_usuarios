package com.Usuario.usuario.controller;


import com.Usuario.usuario.dto.UsuarioRequestDTO;
import com.Usuario.usuario.dto.UsuarioResponseDTO;
import com.Usuario.usuario.model.Usuario;
import com.Usuario.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gym/socios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/listarsocios")
    public ResponseEntity<List<Usuario>> obtenerUsuarios(){
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @GetMapping("/busqueda/{RUN}")
    public ResponseEntity<UsuarioResponseDTO> obtenerUsuarioRUN(@PathVariable String RUN) {
        return ResponseEntity.ok(usuarioService.obtenerPorRUN(RUN));
    }

    @PostMapping
    public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario){
        Usuario nuevo = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(201).body(nuevo);
    }

    // Actualizar Datos usuario
    @PutMapping("/updateuser/{idUsuario}")

    // Borrar usuario
    @DeleteMapping("/deleteuser/{idUsuario}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable Long idUsuario){
        if(usuarioService.obtenerPorId(idUsuario).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        usuarioService.eliminarUsuario(idUsuario);
        return ResponseEntity.noContent().build();
    }
}

