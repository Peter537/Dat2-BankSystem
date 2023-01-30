package main.account;

import main.entities.Customer;

public class PremiumAccount extends BankAccount {

    public PremiumAccount() { }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Kun for VIP
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