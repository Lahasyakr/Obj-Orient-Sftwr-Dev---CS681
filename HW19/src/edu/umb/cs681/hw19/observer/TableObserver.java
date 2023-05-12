package edu.umb.cs681.hw19.observer;

public class TableObserver implements Observer<StockEvent> {

    public void update(Observable<StockEvent> observable, StockEvent object) {
        StockEvent event = (StockEvent) object;
        System.out.print("\n Thread" + Thread.currentThread().getId() + " Table Observer of StockEvent:Shown here  "
                + event.ticker() + " " + event.quote());

    }
}