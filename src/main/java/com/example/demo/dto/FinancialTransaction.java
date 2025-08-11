package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class FinancialTransaction {
    private String transactionId;
    private String accountId;
    private BigDecimal amount;
    private String currency;
    private Instant timestamp;
    private String merchant;
    private String location;

    public FinancialTransaction() {}

    // getters & setters
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }
    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
