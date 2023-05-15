package edu.umb.cs681.hw19;

import java.util.ArrayList;

import edu.umb.cs681.hw19.observer.LineChartObserver;
import edu.umb.cs681.hw19.observer.StockEvent;
import edu.umb.cs681.hw19.observer.StockQuoteObservable;
import edu.umb.cs681.hw19.observer.TableObserver;
import edu.umb.cs681.hw19.observer.Three_3_DObserver;

public class Main {
    public static void main(String[] args) {
        StockQuoteObservable stockObservable = new StockQuoteObservable();
        TableObserver tableObserver = new TableObserver();
        stockObservable.addObserver(tableObserver);
        Three_3_DObserver ThreeDObserver = new Three_3_DObserver();
        stockObservable.addObserver(ThreeDObserver);
        LineChartObserver lineChartObserver = new LineChartObserver();
        stockObservable.addObserver(lineChartObserver);

        ArrayList<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 12; i++) {
            Thread t = new Thread(() -> {

                stockObservable.changeQuote("Rise", 800.0);
                StockEvent a = new StockEvent("crash", 100);
                stockObservable.notifyObservers(a);

                stockObservable.changeQuote("plummet", 300.0);

                StockEvent b = new StockEvent("jump", 400);
                stockObservable.notifyObservers(b);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            threads.add(t);
            t.start();
        }

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        for (int i = 0; i < 12; i++) {
            try {
                threads.get(i).join();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
