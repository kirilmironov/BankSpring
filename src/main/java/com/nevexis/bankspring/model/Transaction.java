package com.nevexis.bankspring.model;

import com.nevexis.bankspring.enums.TransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction extends BaseEntity {

    @ManyToOne
    private Account destinationAccount;

    @ManyToOne
    private Account sourceAccount;

    private BigDecimal amount;

    private LocalDateTime transactionTime;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String iban;

    public Transaction() {

    }

    public Transaction(Account destinationAccount, Account sourceAccount, BigDecimal amount, LocalDateTime transactionTime, TransactionType type, String iban) {
        this.destinationAccount = destinationAccount;
        this.sourceAccount = sourceAccount;
        this.amount = amount;
        this.transactionTime = transactionTime;
        this.type = type;
        this.iban = iban;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "destinationAccount=" + destinationAccount +
                ", sourceAccount=" + sourceAccount +
                ", amount=" + amount +
                ", transactionTime=" + transactionTime +
                ", type=" + type +
                ", iban='" + iban + '\'' +
                '}';
    }
}
