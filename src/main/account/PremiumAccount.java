package main.account;

import main.entities.Customer;
import main.entities.Transaction;
import main.enums.Status;

public class PremiumAccount extends BankAccount {

    public PremiumAccount() { }

    public PremiumAccount(Customer owner) {
        this.setOwner(owner);
    }

    @Override
    public void setOwner(Customer owner) {
        /*
         * Null check, kast exception hvis null
         * Kun for VIP
         */
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }

        if (owner.getStatus() != Status.VIP) {
            throw new IllegalArgumentException("Owner must be VIP");
        }

        this.owner = owner;
    }

    @Override
    public boolean withdraw(double amount) {
        /*
         * Tjekke for negativ tal
         * De kan skylde hvad de vil, de må gerne gå i minus
         */
        if (amount < 0) {
            return false;
        }

        this.transactions.add(new Transaction(amount));
        this.balance -= amount;
        return true;
    }
}