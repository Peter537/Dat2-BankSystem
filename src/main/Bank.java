package main;

import main.account.BankAccount;
import main.entities.Customer;
import main.observer.CustomerObserver;

import java.util.ArrayList;

public class Bank {

    private final ArrayList<Customer> customers = new ArrayList<>();
    private final ArrayList<CustomerObserver> observers = new ArrayList<>();

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
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        boolean added = this.customers.add(customer);
        if (!added) {
            return;
        }

        for (CustomerObserver observer : this.observers) {
            observer.onCustomerAdded(customer);
        }
    }

    public void removeCustomer(Customer customer) {
        /*
         * Null check
         * Tjekke du har en customer du kan slette
         */
        if (customer == null) {
            throw new IllegalArgumentException("Customer kan ikke være null");
        }

        if (this.customers.size() == 0) {
            throw new IllegalArgumentException("Der er ingen customers");
        }

        if (!this.customers.contains(customer)) {
            throw new IllegalArgumentException("Denne customer findes ikke");
        }

        boolean removed = this.customers.remove(customer);
        if (!removed) {
            return;
        }

        for (CustomerObserver observer : this.observers) {
            observer.onCustomerRemoved(customer);
        }
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void addObserver(CustomerObserver observer) {
        /*
         * Null check
         */
        if (observer == null) {
            throw new IllegalArgumentException("Observer kan ikke være null");
        }

        this.observers.add(observer);
    }

    public void removeObserver(CustomerObserver observer) {
        /*
         * Null check
         * Tjekke du har en observer du kan slette
         */
        if (observer == null) {
            throw new IllegalArgumentException("Observer kan ikke være null");
        }

        if (this.observers.size() == 0) {
            throw new IllegalArgumentException("Der er ingen observers");
        }

        if (!this.observers.contains(observer)) {
            throw new IllegalArgumentException("Denne observer findes ikke");
        }

        this.observers.remove(observer);
    }
}