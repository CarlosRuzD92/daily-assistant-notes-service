package com.asistente.notas;

import com.asistente.notas.modelo.Nota;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotaTest {

    @Test
    void deberiaCrearNotaConConstructorVacio() {
        Nota nota = new Nota();

        assertNotNull(nota);
    }

    @Test
    void deberiaInicializarLosCamposANullPorDefecto() {
        Nota nota = new Nota();

        assertNull(nota.getId());
        assertNull(nota.getTitulo());
        assertNull(nota.getContenido());
        assertNull(nota.getFecha());
    }

    @Test
    void deberiaAsignarYLeerLosCamposCorrectamente() {
        Nota nota = new Nota();
        LocalDateTime fecha = LocalDateTime.now();

        nota.setId("1");
        nota.setTitulo("Título de prueba");
        nota.setContenido("Contenido de prueba");
        nota.setFecha(fecha);

        assertEquals("1", nota.getId());
        assertEquals("Título de prueba", nota.getTitulo());
        assertEquals("Contenido de prueba", nota.getContenido());
        assertEquals(fecha, nota.getFecha());
    }

    @Test
    void deberiaCrearNotaConConstructorCompleto() {
        LocalDateTime fecha = LocalDateTime.now();

        Nota nota = new Nota(
                "1",
                "Título de prueba",
                "Contenido de prueba",
                fecha
        );

        assertEquals("1", nota.getId());
        assertEquals("Título de prueba", nota.getTitulo());
        assertEquals("Contenido de prueba", nota.getContenido());
        assertEquals(fecha, nota.getFecha());
    }

    @Test
    void dosNotasConLosMismosDatosDeberianSerIguales() {
        LocalDateTime fecha = LocalDateTime.now();

        Nota nota1 = new Nota("1", "Título", "Contenido", fecha);
        Nota nota2 = new Nota("1", "Título", "Contenido", fecha);

        assertEquals(nota1, nota2);
        assertEquals(nota1.hashCode(), nota2.hashCode());
    }
}
