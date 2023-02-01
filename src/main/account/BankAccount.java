package main.account;

import main.entities.Customer;
import main.entities.Transaction;

import java.util.HashSet;

public abstract class BankAccount {

    protected static int idCounter = 1;
    protected final int id;

    protected double balance;
    protected Customer owner;
    protected HashSet<Transaction> transactions = new HashSet<>();

    public BankAccount() {
        this.id = idCounter;
        idCounter++;
    }

    public abstract void setOwner(Customer owner);

    public abstract boolean withdraw(double amount);

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.balance += amount;
    }

    public int getID() {
        return this.id;
    }

    public double getBalance() {
        return this.balance;
    }

    public Customer getOwner() {
        return this.owner;
    }

    public HashSet<Transaction> getTransactions() {
        return this.transactions;
    }
}