package main.account;

import main.entities.Customer;
import main.entities.Transaction;
import main.enums.Status;

public class SalaryAccount extends BankAccount {

    private double creditLimit;

    public SalaryAccount() { }

    public SalaryAccount(Customer owner) {
        this.setOwner(owner);
    }

    public SalaryAccount(Customer customer, double creditLimit) {
        this.setOwner(customer);
        this.creditLimit = creditLimit;
    }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Null check, kast exception hvis null
         * For VIP og ADULT
         */
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }

        if (owner.getStatus() != Status.VIP && owner.getStatus() != Status.ADULT) {
            throw new IllegalArgumentException("Owner must be VIP or ADULT");
        }

        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        /*
         * Tjekke for negativ tal, eller mindre end hvad creditlimit er
         */
        if (amount < 0) {
            return false;
        }

        if ((this.balance - amount) < this.getCreditLimit()) {
            return false;
        }

        this.transactions.add(new Transaction(amount));
        this.balance -= amount;
        return true;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }
}