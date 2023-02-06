package main.entities;

import java.sql.Timestamp;

public class Transaction {

    private final double amount;
    private final Timestamp timestamp;

    public Transaction(double amount) {
        this.amount = amount;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public double getAmount() {
        return this.amount;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }
}