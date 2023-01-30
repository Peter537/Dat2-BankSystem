package main.account;

import main.entities.Customer;

public class PremiumAccount extends BankAccount {

    public PremiumAccount() { }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Null check, kast exception hvis null
         * Kun for VIP
         */
        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        /*
         * Tjekke for negativ tal
         * De kan skylde hvad de vil, de må gerne gå i minus
         */
        return false;
    }
}