package main;

import main.account.BankAccount;
import main.entities.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private final ArrayList<Customer> customers = new ArrayList<>();

    public Bank() { }

    public boolean transferMoney(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("En Account er null");
        }

        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }

        return false;
    }

    public void addCustomer(Customer customer) {
        /*
         * Null check
         */
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        /*
         * Null check
         * Tjekke du har en customer du kan slette
         */
        this.customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
}