package edu.umb.cs681.hw4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void dataprocessing1(List<List<String>> data) {
        System.out.println("Data processing #1");
        List<List<String>> charlseRiverBound = data.stream().filter((i) -> i.get(3).contains("1"))
                .collect(Collectors.toList());
        System.out.println("\nAreas/blocks next to Charles river: \n" + charlseRiverBound);

        var highesthouseprice = charlseRiverBound.stream().map(item -> item.get(13))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest house price :$" + Float.parseFloat(highesthouseprice) * 1000);

        var lowestthouseprice = charlseRiverBound.stream().map(item -> item.get(13))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest house price :$" + Float.parseFloat(lowestthouseprice) * 1000);

        var averageHousePriceCal = charlseRiverBound.stream().map(
                (item) -> item.get(13)).reduce("0", (result, price) -> {
                    var totalInt = Float.parseFloat(result);
                    var priceInt = Float.parseFloat(price) * 1000;
                    totalInt = totalInt + priceInt;
                    return String.valueOf(totalInt);
                });
        var averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / charlseRiverBound.size();
        System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));

    }

    public static void dataprocessing2(List<List<String>> data) {
        System.out.println("\n\nData processing #2");

        // Collections.sort(data, (a,b)->a.get(0)-b.get(0));

        List<List<String>> sorteddataByPtratioAndCrim = data.stream().sorted((o1, o2) -> {
            if (o1.get(0).compareTo(o2.get(0)) == 0) {
                return o1.get(10).compareTo(o2.get(10));
            } else {
                return o1.get(0).compareTo(o2.get(0));
            }
        }).collect(Collectors.toList());
        var result = sorteddataByPtratioAndCrim.stream().limit(10).collect(Collectors.toList());
        System.out.println(
                "areas/blocks within the top (lowest) 10% of low crime rate and the top (lowest) 10% of pupil-teacher ratio.\n"
                        + result);

        var highesthouseprice = result.stream().map(item -> item.get(13))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest house price :$" + Float.parseFloat(highesthouseprice) * 1000);

        var lowestthouseprice = result.stream().map(item -> item.get(13))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest house price :$" + Float.parseFloat(lowestthouseprice) * 1000);

        var averageHousePriceCal = result.stream().map(
                (item) -> item.get(13)).reduce("0", (result1, price) -> {
                    var totalInt = Float.parseFloat(result1);
                    var priceInt = Float.parseFloat(price) * 1000;
                    totalInt = totalInt + priceInt;
                    return String.valueOf(totalInt);
                });
        var averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / result.size();
        System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));

        var highestNox = result.stream().map(item -> item.get(4))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest Nox Concentration: " + highestNox);

        var lowestNox = result.stream().map(item -> item.get(4))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest Nox Concentration: " + lowestNox);

        var averageNoxvalue = result.stream().map(
                (item) -> item.get(4)).reduce("0", (result1, nox) -> {
                    var totalInt = Float.parseFloat(result1);
                    var noxInt = Float.parseFloat(nox);
                    totalInt = totalInt + noxInt;
                    return String.valueOf(totalInt);
                });
        var averageNox = (Float.parseFloat(averageNoxvalue)) / result.size();
        System.out.println("\n Average Nox Concentarion : " + String.format("%.4f", averageNox));

        var highestNumberOfRooms = result.stream().map(item -> item.get(5))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest Number of Rooms: " + highestNumberOfRooms);

        var lowestNumberOfRooms = result.stream().map(item -> item.get(5))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest  Number of Rooms: " + lowestNumberOfRooms);

        var averageNumberOfRoomsvalue = result.stream().map(
                (item) -> item.get(5)).reduce("0", (result1, room) -> {
                    var totalInt = Float.parseFloat(result1);
                    var roomInt = Float.parseFloat(room);
                    totalInt = totalInt + roomInt;
                    return String.valueOf(totalInt);
                });

        var averageNumberOfRooms = (Float.parseFloat(averageNumberOfRoomsvalue)) / result.size();
        System.out.println("\n Average  Number of Rooms : " + String.format("%.4f", averageNumberOfRooms));

    }

    public static void dataprocessing3(List<List<String>> data) {
        System.out.println("\n\n Data processing #3");

        var avgRommNum = data.stream().map(
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

    public static void dataprocessing4(List<List<String>> data) {
        System.out.println("\n\n Data processing #4");

        var totalAverageWeigtedDist = data.stream().map(
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

    public static void main(String[] args) throws Exception {
        var path = Paths.get("src/edu/umb/cs681/hw4/Data/bos-housing.csv");
        System.out.println(path);

        System.out.println("hi");

        try (Stream<String> lines = Files.lines(path)) {

            List<List<String>> data = lines.skip(1).map(line -> {
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
