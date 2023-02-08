package main.observer;

import main.entities.Customer;

public interface CustomerObserver {

    void onCustomerAdded(Customer customer);

    void onCustomerRemoved(Customer customer);
}