package main.observer;

import java.util.Observable;
import java.util.Observer;

public class ResponseHandler2 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        //System.out.println("ResponseHandler2: " + arg);
        //System.out.println("ResponseHandler2; instanceOf:" + (arg instanceof Double));
        if (arg instanceof Double) {
            //System.out.println("ResponseHandler2: " + arg + " is an Integer");
            double value = (double) arg;
            //System.out.println("ResponseHandler2: " + value);
            if (value >= 10000) {
                System.out.println("ResponseHandler2: " + value);
            }
        }
    }
}