package main.entities;

import main.enums.Status;
import main.account.BankAccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Customer {

    private static int idCounter = 1;
    private final int id;

    private String name;
    private Status status;
    private final ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String name, Status status) {
        this.id = idCounter;
        this.setName(name);
        this.setStatus(status);
        idCounter++;
    }

    public void addAccount(BankAccount account) {
        /*
         * Null check, kast exception
         * BankAccount er tilknyttet denne customer
         */
        if (account == null) {
            throw new IllegalArgumentException("Account er null");
        }

        if (account.getOwner() != this) {
            throw new IllegalArgumentException("Account tilhører ikke denne customer");
        }

        this.accounts.add(account);
    }

    public void removeAccount(BankAccount account) {
        /*
         * Null check, kast exception
         * Tjekke du har en account du kan slette
         * Accounten tilhører dig
         */
        if (account == null) {
            throw new IllegalArgumentException("Account er null");
        }

        if (this.accounts.size() == 0) {
            throw new IllegalArgumentException("Du har ingen accounts");
        }

        if (account.getOwner() != this) {
            throw new IllegalArgumentException("Denne account tilhører ikke denne customer");
        }

        this.accounts.remove(account);
    }

    public void setName(String name) {
        /*
         * Null check, kast exception
         * Ikke indeholder specialtegn, tal, eller er tom
         * Starte med stort forbogstav
         *
         * Sætte name til 'null' hvis den ikke opfylder ovenstående
         */
        Pattern pattern = Pattern.compile("[^a-åA-Å]");
        boolean willThrow = false;
        String throwMessage = "";
        if (name == null) {
            willThrow = true;
            throwMessage = "Navnet er null";
        } else if (name.length() == 0) {
            willThrow = true;
            throwMessage = "Navnet er tom";
        } else if (pattern.matcher(name).find()) {
            willThrow = true;
            throwMessage = "Navnet indeholder specialtegn eller tal";
        }

        if (willThrow) {
            this.name = null;
            throw new IllegalArgumentException(throwMessage);
        }

        this.name = name;
    }

    public void setStatus(Status status) {
        /*
         * Null check, kast exception
         * Tjekke at Status er en korrekt status
         */
        if (status == null) {
            throw new IllegalArgumentException("Status er null");
        }

        if (Arrays.stream(Status.values()).noneMatch(s -> s == status)) {
            throw new IllegalArgumentException("Status er ikke en valid status");
        }

        this.status = status;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Status getStatus() {
        return this.status;
    }
}