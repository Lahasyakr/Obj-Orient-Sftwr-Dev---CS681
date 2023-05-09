package edu.umb.cs681.hw15.observer;

public class Three_3_DObserver implements Observer<StockEvent> {

    public void update(Observable<StockEvent> observable, StockEvent object) {
        StockEvent event = (StockEvent) object;
        System.out.print("\n 3D Observer of StockEvent:Shown here  " + event.ticker() + " " + event.quote());

    }
}
