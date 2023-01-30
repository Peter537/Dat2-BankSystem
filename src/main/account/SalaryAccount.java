package main.account;

import main.entities.Customer;

public class SalaryAccount extends BankAccount {

    private double creditLimit;

    public SalaryAccount() { }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Null check, kast exception hvis null
         * For VIP og ADULT
         */
        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        /*
         * Tjekke for negativ tal, eller mindre end hvad creditlimit er
         */
        return false;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }
}