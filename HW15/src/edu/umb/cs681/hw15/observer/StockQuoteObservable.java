package edu.umb.cs681.hw15.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable<StockEvent> {
	private Map<String, Double> mappings = new HashMap<String, Double>();

	private final ReentrantLock lockTQ = new ReentrantLock();

	public void changeQuote(String T, double Q) {
		lockTQ.lock();
		try {
			mappings.put(T, Q);
		} finally {
			lockTQ.unlock();
		}
		notifyObservers(new StockEvent(T, Q));
		// setChanged();
		
	}

}