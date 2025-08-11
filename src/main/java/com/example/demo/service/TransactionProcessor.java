package com.example.demo.service;

import java.math.BigDecimal;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import com.example.demo.dto.FinancialTransaction;

@Service
public class TransactionProcessor {
    private static final Logger log = LoggerFactory.getLogger(TransactionProcessor.class);

    private static final BigDecimal HIGH_VALUE = new BigDecimal("10000.00");

    public void process(FinancialTransaction tx) {
        log.info("Processing tx {} amount {} {}", tx.getTransactionId(), tx.getAmount(), tx.getCurrency());
        if (isHighValue(tx)) {
            log.warn("HIGH VALUE TRANSACTION detected: {} amount={}", tx.getTransactionId(), tx.getAmount());
            // TODO: push alert to alerts topic / DB
        }
        // TODO: velocity checks, enrichment, persistence...
    }

    private boolean isHighValue(FinancialTransaction tx) {
        if (tx.getAmount() == null) return false;
        return tx.getAmount().compareTo(HIGH_VALUE) >= 0;
    }
}
