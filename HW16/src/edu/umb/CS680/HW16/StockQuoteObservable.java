package edu.umb.CS680.HW16;

public class StockQuoteObservable extends Observable{

    public void changeQuote(String t, double q){
        notifyObservers(new StockEvent(t,q));
        System.out.println("Observer updated");
    }
}