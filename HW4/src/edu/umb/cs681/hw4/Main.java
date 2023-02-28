package edu.umb.cs681.hw4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void dataprocessing1(List<List<String>> data) {
        System.out.println("Data processing #1");
        List<List<String>> charlseRiverBound = data.stream().filter((i) -> i.get(3).contains("1"))
                .collect(Collectors.toList());
        System.out.println("\nAreas/blocks next to Charles river: \n" + charlseRiverBound);

        var highesthouseprice = charlseRiverBound.stream().map(
                (item) -> item.get(13)).reduce("0", (result, price) -> {
                    var totalInt = Float.parseFloat(result);
                    var priceInt = Float.parseFloat(price) * 1000;
                    if (totalInt == 0) {
                        totalInt = priceInt;
                    } else if (priceInt > totalInt) {
                        totalInt = priceInt;
                    }
                    return String.valueOf(totalInt);
                });
        System.out.println("\n Highest house price :$" + highesthouseprice);

        var lowestthouseprice = charlseRiverBound.stream().map(
                (item) -> item.get(13)).reduce("0", (result, price) -> {
                    var totalInt = Float.parseFloat(result);
                    var priceInt = Float.parseFloat(price) * 1000;
                    if (totalInt == 0) {
                        totalInt = priceInt;
                    } else if (priceInt < totalInt) {
                        totalInt = priceInt;
                    }
                    return String.valueOf(totalInt);
                });
        System.out.println("\n Lowest house price :$" + lowestthouseprice);

        var averageHousePriceCal = charlseRiverBound.stream().map(
                (item) -> item.get(13)).reduce("0", (result, price) -> {
                    var totalInt = Float.parseFloat(result);
                    var priceInt = Float.parseFloat(price) * 1000;
                    totalInt = +priceInt;
                    return String.valueOf(totalInt);
                });
        var averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / charlseRiverBound.size();
        System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));

    }

    public static void dataprocessing2(List<List<String>> data) {
        System.out.println("\n\nData processing #2");

        System.out.println(data.size());

        List<List<String>> charlseRiverBound = data.stream().filter((i) -> i.get(3).contains("1"))
                .collect(Collectors.toList());
    }

    public static void dataprocessing3(List<List<String>> data) {
        System.out.println("\n\n Data processing #3");

        var avgRommNum = data.stream().map(
                (item) -> item.get(5)).reduce("0", (result, price) -> {
                    if (price != "rm") {
                        try {
                            var totalInt = Float.parseFloat(result);
                            var priceInt = Float.parseFloat(price);
                            totalInt = +priceInt;
                            return String.valueOf(totalInt);
                        } catch (NumberFormatException ignored) {
                        }
                    } 
                    return result;
                });

        System.out.println(
                "\nTotal average number of rooms per dwelling :" + Float.parseFloat(avgRommNum) / (data.size() - 1));
    }

    public static void dataprocessing4(List<List<String>> data) {
        System.out.println("\n\n Data processing #4");

        var totalAverageWeigtedDist = data.stream().map(
                (item) -> item.get(6)).reduce("0", (result, price) -> {
                    if (price != "DIS") {
                        try {
                            var totalInt = Float.parseFloat(result);
                            var priceInt = Float.parseFloat(price);
                            totalInt = +priceInt;
                            return String.valueOf(totalInt);
                        } catch (NumberFormatException ignored) {
                        }
                    } 
                    return result;
                });

        System.out.println(
                "\nTotal of Weighted distance to boston employment center :" + totalAverageWeigtedDist);
    }
    public static void main(String[] args) throws Exception {
        var path = Paths.get("src/edu/umb/cs681/hw4/Data/bos-housing.csv");
        System.out.println(path);

        System.out.println("hi");

        try (Stream<String> lines = Files.lines(path)) {

            List<List<String>> data = lines.map(line -> {
                return Stream.of(line.split(",")).map(value -> value.substring(0, value.length()))
                        .collect(Collectors.toList());
            }).collect(Collectors.toList());
            // System.out.println("\nEntire data: \n" + data);
            dataprocessing1(data);
            dataprocessing2(data);
            dataprocessing3(data);
            dataprocessing4(data);
        } catch (IOException ex) {
            System.out.println("Exception");
            // do something or re-throw...
        }
    }
}
