package com.asistente.notas.eventos;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicadorEventosNota {

    private static final String TOPIC = "notas.eventos";

    private final KafkaTemplate<String, Object> kafka;

    public void publicarCreada(EventoNotaCreada evt) {
        kafka.send(TOPIC, evt.getId(), evt)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Fallo publicando EventoNotaCreada id={}, error={}", evt.getId(), ex.toString());
                    } else {
                        var meta = result.getRecordMetadata();
                        log.info("EventoNotaCreada OK id={} topic={} partition={} offset={}",
                                evt.getId(), meta.topic(), meta.partition(), meta.offset());
                    }
                });
    }
}

