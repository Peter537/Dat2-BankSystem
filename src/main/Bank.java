package main;

import main.account.BankAccount;
import main.entities.Customer;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();
    private final ArrayList<Customer> customers = new ArrayList<>();

    public Bank() { }

    public boolean transferMoney(int fromBankAccountID, int toBankAccountID, double amount) {
        BankAccount fromAccount = this.accounts.getOrDefault(fromBankAccountID, null);
        BankAccount toAccount = this.accounts.getOrDefault(toBankAccountID, null);
        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }

        return false;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addAccount(BankAccount account) {
        this.accounts.put(account.getID(), account);
    }

    public void removeCustomer(Customer customer) {
        this.customers.remove(customer);
    }

    public void removeAccount(BankAccount account) {
        this.accounts.remove(account.getID());
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public HashMap<Integer, BankAccount> getAccounts() {
        return this.accounts;
    }
}