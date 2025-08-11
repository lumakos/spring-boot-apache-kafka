package com.example.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.demo.dto.FinancialTransaction;
import com.example.demo.service.TransactionProcessor;

@Component
public class TransactionConsumer {
     private final TransactionProcessor processor;

    public TransactionConsumer(TransactionProcessor processor) {
        this.processor = processor;
    }

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(FinancialTransaction transaction) {
        if (transaction == null) return;
        processor.process(transaction);
        System.out.println(String.format("Consumed message -> %s", transaction.getTransactionId()));

    }
}
