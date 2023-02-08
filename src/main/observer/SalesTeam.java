package main.observer;

import main.entities.Customer;

public class SalesTeam implements CustomerObserver {

    @Override
    public void onCustomerAdded(Customer customer) {
        System.out.println("Hello " + customer.getName() + ", welcome to the bank!");
    }

    @Override
    public void onCustomerRemoved(Customer customer) {
        System.out.println("Hello " + customer.getName() + ", where did you go?");
    }

    public void makeCampaign() {
        System.out.println("Write to all media");
    }
}