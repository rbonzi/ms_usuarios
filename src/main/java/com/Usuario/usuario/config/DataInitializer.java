package com.Usuario.usuario.config;

import com.Usuario.usuario.model.Membresia;
import com.Usuario.usuario.model.Usuario;
import com.Usuario.usuario.repository.MembresiaRepository;
import com.Usuario.usuario.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final MembresiaRepository membresiaRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args){
        if(usuarioRepository.count() > 0){
            log.info("Datos cargados");
            return;
        }

        log.info("No hay datos guardados, creando datos");

        // Solo para pruebas

        Membresia mem1 = new Membresia(1L,"Mensual","20000");
        Membresia mem2 = new Membresia(2L,"Trimestral","35000");
        Membresia mem3 = new Membresia(3L,"Semestral","100000");
        Membresia mem4 = new Membresia(4L,"Anual","180000");

        usuarioRepository.save(new Usuario(null, "Driscoll Atkins", "odio.vel@hotmail.com", "256628166", mem3));
        usuarioRepository.save(new Usuario(null, "Lester Graves", "faucibus.id@hotmail.com", "558297262", mem1));
        usuarioRepository.save(new Usuario(null, "Shana Calhoun", "parturient@hotmail.com", "488439752", mem2));
        usuarioRepository.save(new Usuario(null, "Elvis Rogers", "lectus@google.com", "913018327", mem1));
        usuarioRepository.save(new Usuario(null, "Adrian Cardenas", "tincidunt.congue@google.com", "516791034", mem1));


    }
}
