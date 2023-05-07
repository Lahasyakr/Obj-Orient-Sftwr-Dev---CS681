package edu.umb.cs681.hw15.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable<StockEvent> {
	private Map<String, Double> mappings = new HashMap<String, Double>();

	private ReentrantLock lockTQ = new ReentrantLock();

	void changeQuote(String T, double Q) {
		try {
			lockTQ.lock();
			mappings.put(T, Q);
		} finally {
			lockTQ.unlock();
		}

		// setChanged();
		notifyObservers(new StockEvent(T, Q));
	}

}