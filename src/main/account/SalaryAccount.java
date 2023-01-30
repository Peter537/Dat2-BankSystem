package main.account;

import main.entities.Customer;

public class SalaryAccount extends BankAccount {

    private double creditLimit;

    public SalaryAccount() { }

    @Override
    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }
}