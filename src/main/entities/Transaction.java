package main.entities;

import java.security.Timestamp;

public class Transaction {

    private final double amount;
    private final Timestamp timestamp;

    public Transaction(double amount, Timestamp timestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return this.amount;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }
}