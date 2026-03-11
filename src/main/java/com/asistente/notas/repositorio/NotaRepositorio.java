package com.asistente.notas.repositorio;

import com.asistente.notas.modelo.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotaRepositorio extends MongoRepository<Nota, String> {}

