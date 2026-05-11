package com.Usuario.usuario.repository;

import com.Usuario.usuario.model.Membresia;
import com.Usuario.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembresiaRepository extends JpaRepository<Membresia,Long> {
}
