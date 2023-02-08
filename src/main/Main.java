package main;

import main.entities.Customer;
import main.enums.Status;
import main.observer.SalesTeam;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        SalesTeam salesTeam = new SalesTeam();
        bank.addObserver(salesTeam);

        Customer customer1 = new Customer("John", Status.ADULT);
        Customer customer2 = new Customer("Jane", Status.ADULT);

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        bank.removeCustomer(customer1);
    }
}