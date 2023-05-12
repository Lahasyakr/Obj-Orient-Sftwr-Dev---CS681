package edu.umb.cs681.hw20;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class DataProcessing_2 {
    public static void dataprocessing2(List<List<String>> data) {
        System.out.println("\n\nData processing #2");

        // Collections.sort(data, (a,b)->a.get(0)-b.get(0));

        List<List<String>> sorteddataByPtratioAndCrim = data.parallelStream().sorted((o1, o2) -> {
            if (o1.get(0).compareTo(o2.get(0)) == 0) {
                return o1.get(10).compareTo(o2.get(10));
            } else {
                return o1.get(0).compareTo(o2.get(0));
            }
        }).collect(Collectors.toList());
        var result = sorteddataByPtratioAndCrim.parallelStream().limit(10).collect(Collectors.toList());
        System.out.println(
                "areas/blocks within the top (lowest) 10% of low crime rate and the top (lowest) 10% of pupil-teacher ratio.\n"
                        + result);

        var highesthouseprice = result.parallelStream().map(item -> item.get(13))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest house price :$" + Float.parseFloat(highesthouseprice) * 1000);

        var lowestthouseprice = result.parallelStream().map(item -> item.get(13))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest house price :$" + Float.parseFloat(lowestthouseprice) * 1000);

        var averageHousePriceCal = result.parallelStream().map(
                (item) -> item.get(13)).reduce("0", (result1, price) -> {
                    var totalInt = Float.parseFloat(result1);
                    var priceInt = Float.parseFloat(price) * 1000;
                    totalInt = totalInt + priceInt;
                    return String.valueOf(totalInt);
                });
        var averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / result.size();
        System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));

        var highestNox = result.parallelStream().map(item -> item.get(4))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest Nox Concentration: " + highestNox);

        var lowestNox = result.parallelStream().map(item -> item.get(4))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest Nox Concentration: " + lowestNox);

        var averageNoxvalue = result.parallelStream().map(
                (item) -> item.get(4)).reduce("0", (result1, nox) -> {
                    var totalInt = Float.parseFloat(result1);
                    var noxInt = Float.parseFloat(nox);
                    totalInt = totalInt + noxInt;
                    return String.valueOf(totalInt);
                });
        var averageNox = (Float.parseFloat(averageNoxvalue)) / result.size();
        System.out.println("\n Average Nox Concentarion : " + String.format("%.4f", averageNox));

        var highestNumberOfRooms = result.parallelStream().map(item -> item.get(5))
                .max(Comparator.comparing(price -> price)).get();

        System.out.println("\n Highest Number of Rooms: " + highestNumberOfRooms);

        var lowestNumberOfRooms = result.parallelStream().map(item -> item.get(5))
                .min(Comparator.comparing(price -> price)).get();
        System.out.println("\n Lowest  Number of Rooms: " + lowestNumberOfRooms);

        var averageNumberOfRoomsvalue = result.parallelStream().map(
                (item) -> item.get(5)).reduce("0", (result1, room) -> {
                    var totalInt = Float.parseFloat(result1);
                    var roomInt = Float.parseFloat(room);
                    totalInt = totalInt + roomInt;
                    return String.valueOf(totalInt);
                });

        var averageNumberOfRooms = (Float.parseFloat(averageNumberOfRoomsvalue)) / result.size();
        System.out.println("\n Average  Number of Rooms : " + String.format("%.4f", averageNumberOfRooms));

    }

}
