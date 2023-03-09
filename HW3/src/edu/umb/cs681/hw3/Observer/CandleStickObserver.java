package edu.umb.cs681.hw3.Observer;

import edu.umb.cs681.hw3.Summary.WkSummary;

public class CandleStickObserver implements Observer {

    public void update(Observable observable, Object object) {
        WkSummary event = (WkSummary) object;
        System.out.print("\n Weekly summary is shown here \n " + " \n week open :  " + event.getOpen() + "\n Week close : "
                + event.getClose() + "\n Week high : "
                + event.getHigh() + "\n Week low : " + event.getLow());

    }

}
