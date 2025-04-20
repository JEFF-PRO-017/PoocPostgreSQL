package com.pooc.poocpostgresql.common;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendUserCreatedEvent(String message) {
        kafkaTemplate.send("user-created", message);
    }
}
