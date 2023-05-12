package edu.umb.cs681.hw19.observer;

public class Three_3_DObserver implements Observer<StockEvent> {

    public void update(Observable<StockEvent> observable, StockEvent object) {
        StockEvent event = (StockEvent) object;
        System.out.print("\n Thread" + Thread.currentThread().getId() + " 3D Observer of StockEvent:Shown here  "
                + event.ticker() + " " + event.quote());

    }
}
