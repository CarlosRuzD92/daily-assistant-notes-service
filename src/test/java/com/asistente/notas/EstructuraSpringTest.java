package com.asistente.notas;

import com.asistente.notas.controlador.NotaControlador;
import com.asistente.notas.modelo.Nota;
import com.asistente.notas.servicio.NotaServicio;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EstructuraSpringTest {

    @Test
    void notaControlador_deberiaSerRestController() {
        assertTrue(
                NotaControlador.class.isAnnotationPresent(RestController.class),
                "NotaControlador debería llevar @RestController"
        );
    }

    @Test
    void notaControlador_deberiaTenerRutaBaseNotas() {
        RequestMapping requestMapping = NotaControlador.class.getAnnotation(RequestMapping.class);
        assertNotNull(requestMapping, "NotaControlador debería llevar @RequestMapping");

        boolean contieneRutaNotas = Stream.concat(
                        Arrays.stream(requestMapping.value()),
                        Arrays.stream(requestMapping.path())
                )
                .map(String::toLowerCase)
                .anyMatch(ruta -> ruta.contains("notas"));

        assertTrue(contieneRutaNotas, "La ruta base del controlador debería contener 'notas'");
    }

    @Test
    void notaControlador_deberiaTenerAlMenosUnEndpointMapeado() {
        boolean tieneAlgunEndpoint = Arrays.stream(NotaControlador.class.getDeclaredMethods())
                .anyMatch(this::esMetodoMapeado);

        assertTrue(tieneAlgunEndpoint, "El controlador debería tener al menos un endpoint mapeado");
    }

    @Test
    void notaServicio_deberiaSerService() {
        assertTrue(
                NotaServicio.class.isAnnotationPresent(Service.class),
                "NotaServicio debería llevar @Service"
        );
    }

    @Test
    void nota_deberiaTenerCamposDeclarados() {
        assertTrue(
                Nota.class.getDeclaredFields().length > 0,
                "La entidad Nota debería tener al menos un campo"
        );
    }

    @Test
    void nota_deberiaTenerCampoId() {
        boolean tieneId = Arrays.stream(Nota.class.getDeclaredFields())
                .anyMatch(field -> field.getName().equalsIgnoreCase("id"));

        assertTrue(tieneId, "La entidad Nota debería tener un campo id");
    }

    private boolean esMetodoMapeado(Method method) {
        return method.isAnnotationPresent(GetMapping.class)
                || method.isAnnotationPresent(PostMapping.class)
                || method.isAnnotationPresent(PutMapping.class)
                || method.isAnnotationPresent(DeleteMapping.class)
                || method.isAnnotationPresent(RequestMapping.class);
    }
}