package edu.umb.cs681.hw5;

import java.util.List;

public class RunnableDataProcessing_3 implements Runnable {
    private List<List<String>> data;
    private String avgRommNum;

    public RunnableDataProcessing_3(List<List<String>> data) {
        this.data = data;
    }

    public void getResults() {
        System.out.println("\n\n Data processing #3");
        System.out.println(
                "\nTotal average number of rooms per dwelling :" + Float.parseFloat(avgRommNum) / (data.size()));

    };

    public void run() {
   

        this.avgRommNum = this.data.stream().map(
                (item) -> item.get(5)).reduce("0", (result, price) -> {

                    try {
                        var totalInt = Float.parseFloat(result);
                        var priceInt = Float.parseFloat(price);
                        totalInt = totalInt + priceInt;
                        return String.valueOf(totalInt);
                    } catch (NumberFormatException ignored) {
                    }

                    return result;
                });

       
    }
}
