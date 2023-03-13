package edu.umb.cs681.hw5;

import java.util.List;

public class RunnableDataProcessing_4 implements Runnable {
    private List<List<String>> data;
    private String totalAverageWeigtedDist;

    public RunnableDataProcessing_4(List<List<String>> data) {
        this.data = data;
    }

    public void getResults() {
        System.out.println("\n\n Data processing #4");
        System.out.println(
            "\nTotal of Weighted distance to boston employment center :" + totalAverageWeigtedDist);
    };

    public void run() {
       

        this.totalAverageWeigtedDist = this.data.stream().map(
                (item) -> item.get(6)).reduce("0", (result, price) -> {

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
