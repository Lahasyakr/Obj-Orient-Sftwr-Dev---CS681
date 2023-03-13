package edu.umb.cs681.hw5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RunnableDataProcessing_1 implements Runnable {
        private List<List<String>> data;
        private String highesthouseprice;
        private String lowestthouseprice;
        private Float averageHousePrice;
        private List<List<String>> charlseRiverBound;

        public RunnableDataProcessing_1(List<List<String>> data) {
                this.data = data;
        }
        public void getResults(){
                System.out.println("Data processing #1"); 
                System.out.println("\nAreas/blocks next to Charles river: \n" + charlseRiverBound);
                System.out.println("\n Highest house price :$" + Float.parseFloat(highesthouseprice) * 1000);
                System.out.println("\n Lowest house price :$" + Float.parseFloat(lowestthouseprice) * 1000);
                System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));
        }
        public void run() {
                this.charlseRiverBound = this.data.stream().filter((i) -> i.get(3).contains("1"))
                                .collect(Collectors.toList());
               

                this.highesthouseprice = this.charlseRiverBound.stream().map(item -> item.get(13))
                                .max(Comparator.comparing(price -> price)).get();

                

                 this.lowestthouseprice = charlseRiverBound.stream().map(item -> item.get(13))
                                .min(Comparator.comparing(price -> price)).get();
                

                var averageHousePriceCal = charlseRiverBound.stream().map(
                                (item) -> item.get(13)).reduce("0", (result, price) -> {
                                        var totalInt = Float.parseFloat(result);
                                        var priceInt = Float.parseFloat(price) * 1000;
                                        totalInt = totalInt + priceInt;
                                        return String.valueOf(totalInt);
                                });
                 this.averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / charlseRiverBound.size();
               

        }

}
