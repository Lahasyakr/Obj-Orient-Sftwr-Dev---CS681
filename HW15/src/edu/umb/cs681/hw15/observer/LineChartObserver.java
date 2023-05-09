package edu.umb.cs681.hw15.observer;

public class LineChartObserver implements Observer<StockEvent> {
    public void update(Observable<StockEvent> observable, StockEvent object) {
        StockEvent event = (StockEvent) object;
        System.out.print("\n Line Chart Observer of StockEvent:Shown here  " + event.ticker() + " " + event.quote());
    }
}
