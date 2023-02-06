package main;

import main.account.BankAccount;
import main.entities.Customer;

import java.util.ArrayList;
import java.util.Observable;

public class Bank extends Observable {

    private final ArrayList<Customer> customers = new ArrayList<>();

    public Bank() { }

    public boolean transferMoney(BankAccount fromAccount, BankAccount toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("En Account er null");
        }

        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            this.setChanged();
            this.notifyObservers(amount);
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

        this.customers.add(customer);
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

        this.customers.remove(customer);
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }
}