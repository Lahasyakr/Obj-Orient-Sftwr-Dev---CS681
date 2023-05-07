package edu.umb.cs681.hw15.observer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableStockQuoteObservable implements Runnable {
    private AtomicBoolean done = new AtomicBoolean(false);
    private ReentrantLock lock = new ReentrantLock();

    public void setDone() {
        lock.lock();
        try {
            done.set(true);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

        StockQuoteObservable item = new StockQuoteObservable();
        while (true) { // for infinite loop
            lock.lock();
            try {
                if (done.get()) {
                    System.out.println("Terminated");
                    break;
                }

                TableObserver tableObserver = new TableObserver();
                item.addObserver(tableObserver);
                LineChartObserver lineChartObserver = new LineChartObserver();
                item.addObserver(lineChartObserver);
                Three_3_DObserver ThreeDObserver = new Three_3_DObserver();
                item.addObserver(ThreeDObserver);
                StockEvent a = new StockEvent("crash", 100);
                item.notifyObservers(a);

                item.changeQuote("jump", 300.0);

                StockEvent b = new StockEvent("jump", 400);
                item.notifyObservers(b);
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }
    }
}
