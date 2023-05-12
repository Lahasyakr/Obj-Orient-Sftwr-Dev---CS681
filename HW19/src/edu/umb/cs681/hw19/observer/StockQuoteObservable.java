package edu.umb.cs681.hw19.observer;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent> {
	private Map<String, Double> mappings = new HashMap<String, Double>();

	public void changeQuote(String T, double Q) {
		mappings.put(T, Q);
        notifyObservers(new StockEvent(T, Q));

		// setChanged();
		
	}

}