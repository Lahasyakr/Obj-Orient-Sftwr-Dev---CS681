package edu.umb.cs681.hw20;

import java.util.List;

public class DataProcessing_4 {
    public static void dataprocessing4(List<List<String>> data) {
        System.out.println("\n\n Data processing #4");

        var totalAverageWeigtedDist = data.parallelStream().map(
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

        System.out.println(
                "\nTotal of Weighted distance to boston employment center :" + totalAverageWeigtedDist);
    }

}
