package com.asistente.notas.servicio;

import com.asistente.notas.eventos.EventoNotaCreada;
import com.asistente.notas.eventos.PublicadorEventosNota;
import com.asistente.notas.modelo.Nota;
import com.asistente.notas.repositorio.NotaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor

public class NotaServicio {

    private final NotaRepositorio repo;
    private final PublicadorEventosNota publicador;
    /**
     * Crea la nota y emite el evento
     */
    public Nota crear(Nota nueva, String usuarioActual) {

        Nota guardada = repo.save(nueva);

        String c = guardada.getContenido();
        String snippet = (c == null || c.isBlank()) ? "" : c.substring(0, Math.min(120, c.length()));

        EventoNotaCreada evt = EventoNotaCreada.builder()
                .id(guardada.getId())
                .titulo(guardada.getTitulo())
                .contenido(snippet)
                .fecha(guardada.getFecha() != null ? guardada.getFecha().toString() : null)
                .build();

        log.info("Publicando EventoNotaCreada id={} titulo={}", evt.getId(), evt.getTitulo());

        publicador.publicarCreada(evt);

        return guardada;
    }
}
