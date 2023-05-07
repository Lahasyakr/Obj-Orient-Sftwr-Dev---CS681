package edu.umb.cs681.hw15.observer;

public class TableObserver implements Observer<StockEvent> {

    public void update(Observable<StockEvent> observable, StockEvent object) {
        StockEvent event = (StockEvent) object;
        System.out.print("\n Table Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());

    }
}