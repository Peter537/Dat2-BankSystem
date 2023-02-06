package main.account;

import main.entities.Customer;
import main.enums.Status;

public class PenguinAccount extends BankAccount {

    public PenguinAccount() { }

    public PenguinAccount(Customer owner) {
        this.setOwner(owner);
    }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Null check, kast exception hvis null
         * Kun for CHILD
         */
        if (owner == null) {
            throw new IllegalArgumentException("Kontoen skal have en ejer");
        }

        if (owner.getStatus() != Status.CHILD) {
            throw new IllegalArgumentException("Kontoen er kun for børn");
        }

        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        /*
         * Tjekke for negativ tal, eller mindre end hvad kontoen har
         */
        if (amount < 0) {
            return false;
        }

        if (amount > this.balance) {
            return false;
        }

        this.balance -= amount;
        return true;
    }
}