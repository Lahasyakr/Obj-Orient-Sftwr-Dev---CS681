package edu.umb.cs681.hw3.Observer;

import java.util.LinkedList;

import edu.umb.cs681.hw3.Summary.DSummary;
import edu.umb.cs681.hw3.Summary.Summary;
import edu.umb.cs681.hw3.Summary.WkSummary;

public class DJIAWkSummaryObservable<SummDary> extends Observable<Summary> {
	private LinkedList<DSummary> collectionOfDailySummary = new LinkedList<>();
	// private Map<DSummary> mappings = new HashMap<DSummary>();
	private double open;
	private double close;
	private double high;
	private double low;

	public void addSummary(DSummary dSummary) {
		if (collectionOfDailySummary != null &&  collectionOfDailySummary.size() == 4) {
			collectionOfDailySummary.add(dSummary);
			open = collectionOfDailySummary.get(4).getOpen();
			close = collectionOfDailySummary.get(0).getClose();
			high = collectionOfDailySummary.get(0).getHigh();
			low = collectionOfDailySummary.get(0).getLow();

			collectionOfDailySummary.forEach((item) -> {

				if (item.getHigh() > high) {
					high = item.getHigh();

				} else if (item.getLow() < low) {

					low = item.getLow();
				}

			});
			WkSummary weekSummary = new WkSummary(open, close, high, low);
			notifyObservers(weekSummary);

		} else {
			collectionOfDailySummary.add(dSummary);

		}
	}

}
