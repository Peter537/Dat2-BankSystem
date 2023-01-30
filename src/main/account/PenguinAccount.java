package main.account;

import main.entities.Customer;

public class PenguinAccount extends BankAccount {

    public PenguinAccount() { }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Kun for CHILD
         */
        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        /*
         * Tjekke for negativ tal, eller mindre end hvad kontoen har
         */
        return false;
    }
}