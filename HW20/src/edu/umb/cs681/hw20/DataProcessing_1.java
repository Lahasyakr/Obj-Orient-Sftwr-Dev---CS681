package edu.umb.cs681.hw20;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataProcessing_1 {

    public static void dataprocessing1(List<List<String>> data) {
        System.out.println("Data processing #1");
        List<List<String>> charlseRiverBound = data.parallelStream().filter((i) -> i.get(3).contains("1"))
                .collect(Collectors.toList());
        System.out.println("\nAreas/blocks next to Charles river: \n" + charlseRiverBound);

        var highesthouseprice = charlseRiverBound.parallelStream().map(item -> item.get(13))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest house price :$" + Float.parseFloat(highesthouseprice) * 1000);

        var lowestthouseprice = charlseRiverBound.parallelStream().map(item -> item.get(13))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest house price :$" + Float.parseFloat(lowestthouseprice) * 1000);

        var averageHousePriceCal = charlseRiverBound.parallelStream().map(
                (item) -> item.get(13)).reduce("0", (result, price) -> {
                    var totalInt = Float.parseFloat(result);
                    var priceInt = Float.parseFloat(price) * 1000;
                    totalInt = totalInt + priceInt;
                    return String.valueOf(totalInt);
                });
        var averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / charlseRiverBound.size();
        System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));

    }
}
