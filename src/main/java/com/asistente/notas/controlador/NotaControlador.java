package com.asistente.notas.controlador;

import com.asistente.notas.modelo.Nota;
import com.asistente.notas.repositorio.NotaRepositorio;
import com.asistente.notas.servicio.NotaServicio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/notas")
@RequiredArgsConstructor
public class NotaControlador {

    private final NotaRepositorio nota_repositorio;
    private final NotaServicio servicio;

    @GetMapping
    public List<Nota> getAll() {
        log.debug("Listar notas");
        return nota_repositorio.findAll();
    }

    @PostMapping
    public Nota save(@RequestBody Nota nota) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String usuarioActual = (auth != null ? auth.getName() : null);

        log.info("Crear nota titulo='{}'", nota != null ? nota.getTitulo() : null);

        Nota guardada = servicio.crear(nota, usuarioActual);

        log.info("Nota creada id='{}'", guardada != null ? guardada.getId() : null);
        return guardada;
    }

    @PutMapping("/{id}")
    public Nota updateNota(@PathVariable String id, @RequestBody Nota nuevaNota) {
        log.info("Actualizar nota id='{}' titulo='{}'", id, nuevaNota != null ? nuevaNota.getTitulo() : null);
        return nota_repositorio.findById(id).map(nota -> {
            assert nuevaNota != null;
            nota.setTitulo(nuevaNota.getTitulo());
            nota.setContenido(nuevaNota.getContenido());
            if (nuevaNota.getFecha() != null) {
                nota.setFecha(nuevaNota.getFecha());
            }
            Nota actualizada = nota_repositorio.save(nota);
            log.info("Nota actualizada id='{}'", actualizada.getId());
            return actualizada;
        }).orElseGet(() -> {
            assert nuevaNota != null;
            nuevaNota.setId(id);
            Nota creada = nota_repositorio.save(nuevaNota);
            log.info("Nota creada (upsert) id='{}'", creada.getId());
            return creada;
        });
    }

    @DeleteMapping("/{id}")
    public void deleteNota(@PathVariable String id) {
        log.info("Borrar nota id='{}'", id);
        nota_repositorio.deleteById(id);
        log.info("Nota borrada id='{}'", id);
    }
}
