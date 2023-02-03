package main;

import main.account.BankAccount;
import main.entities.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();
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

    public void addAccount(BankAccount account) {
        /*
         * Null check
         */
        this.accounts.put(account.getID(), account);
    }

    public void removeCustomer(Customer customer) {
        /*
         * Null check
         * Tjekke du har en customer du kan slette
         */
        this.customers.remove(customer);
    }

    public void removeAccount(BankAccount account) {
        /*
         * Null check
         * Tjekke du har en account du kan slette
         */
        this.accounts.remove(account.getID());
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public HashMap<Integer, BankAccount> getAccounts() {
        return this.accounts;
    }
}