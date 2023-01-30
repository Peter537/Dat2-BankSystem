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
        BankAccount fromAccount = this.accounts.get(fromBankAccountID);
        BankAccount toAccount = this.accounts.get(toBankAccountID);
        if (fromAccount == null || toAccount == null) {
            return false;
        }

        if (fromAccount.withdraw(amount)) {
            toAccount.deposit(amount);
            return true;
        }

        return false;
    }
}