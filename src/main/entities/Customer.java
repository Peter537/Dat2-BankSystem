package main.entities;

import main.enums.Status;
import main.account.BankAccount;

import java.util.ArrayList;

public class Customer {

    private static int idCounter = 0;
    private final int id;

    private String name;
    private Status status;
    private final ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String name, Status status) {
        idCounter++;
        this.id = idCounter;
        this.setName(name);
        this.setStatus(status);
    }

    public void addAccount(BankAccount account) {
        /*
         * Null check, kast exception
         */
        this.accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        /*
         * Null check, kast exception
         * Tjekke du har en account du kan slette
         * Accounten tilhører dig
         */
        this.accounts.remove(account);
    }

    public void setName(String name) {
        /*
         * Null check, kast exception
         * Ikke indeholder specialtegn, tal, eller er tom
         */
        this.name = name;
    }

    public void setStatus(Status status) {
        /*
         * Tjekke at Status er en korrekt status
         */
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