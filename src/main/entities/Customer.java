package main.entities;

import main.enums.Status;
import main.account.BankAccount;

import java.util.ArrayList;

public class Customer {

    private static int idCounter = 1;
    private final int id;

    private String name;
    private Status status;
    private final ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String name, Status status) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.status = status;
    }

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        this.accounts.remove(account);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }
}