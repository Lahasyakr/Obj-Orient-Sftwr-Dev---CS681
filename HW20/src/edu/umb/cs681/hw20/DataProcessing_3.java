package edu.umb.cs681.hw20;


import java.util.List;


public class DataProcessing_3 {
    public static void dataprocessing3(List<List<String>> data) {
        System.out.println("\n\n Data processing #3");

        var avgRommNum = data.parallelStream().map(
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

        System.out.println(
                "\nTotal average number of rooms per dwelling :" + Float.parseFloat(avgRommNum) / (data.size()));
    }
}
