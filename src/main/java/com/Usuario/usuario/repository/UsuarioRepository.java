package com.Usuario.usuario.repository;

import com.Usuario.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    boolean existsByRUN(String RUN);

    Optional<Usuario> findByRUN(String RUN);





}
