package com.example.demo.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.dto.FinancialTransaction;

@Component
public class TransactionProducer {
    private KafkaTemplate<String, FinancialTransaction> kafkaTemplate;

    private final String topic;

    public TransactionProducer(KafkaTemplate<String, FinancialTransaction> kafkaTemplate,
                               @Value("${app.kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(FinancialTransaction tx) {
        System.out.println(String.format("Producing message -> %s", tx));
        kafkaTemplate.send(topic, tx.getTransactionId(), tx);
    }
}
