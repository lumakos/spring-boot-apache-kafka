package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @KafkaListener(topics = "first_topic", groupId = "my-consumer-group")
    public void listen(String message) {
        System.out.println(String.format("Consumed message -> %s", message));
    }
}
