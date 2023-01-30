package main.account;

import main.entities.Customer;

public class PenguinAccount extends BankAccount {

    public PenguinAccount() { }

    @Override
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}