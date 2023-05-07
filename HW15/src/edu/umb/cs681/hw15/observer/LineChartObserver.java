package edu.umb.cs681.hw15.observer;

public class LineChartObserver implements Observer<StockEvent> {
    public void update(Observable<StockEvent> observable, StockEvent object) {
        StockEvent event = (StockEvent) object;
        System.out.print(" Line Chart Observer of StockEvent:Shown here  " + event.getTicker() + " " + event.getQuote());
    }
}
