package main.observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ResponseHandler1: " + arg);
    }
}