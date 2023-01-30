package main.account;

import main.entities.Customer;

public class PremiumAccount extends BankAccount {

    public PremiumAccount() { }

    @Override
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}