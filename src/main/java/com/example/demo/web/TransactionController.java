package com.example.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.producer.TransactionProducer;
import com.example.demo.dto.FinancialTransaction;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    
    private final TransactionProducer producer;

    public TransactionController(TransactionProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody FinancialTransaction tx) {
        producer.send(tx);
        return ResponseEntity.accepted().body("sent");
    }
}
