package com.pooc.poocpostgresql.common;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PersonConsumer {
    @KafkaListener(topics = "user-created", groupId = "person-group")
    public void consume(ConsumerRecord<String, String> record) {
        System.out.println("Event reçu : " + record.value());
        // Ici tu pourrais mettre à jour une vue, ou une base de projection (CQRS)
    }
}
