package edu.umb.cs681.hw5;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RunnableDataProcessing_2 implements Runnable {
        private List<List<String>> data;
        private List<List<String>> result;
        private String highesthouseprice;
        private String lowestthouseprice;
        private Float averageHousePrice;
        private String highestNox;
        private String lowestNox;
        private Float averageNox;
        private String highestNumberOfRooms;
        private String lowestNumberOfRooms;
        private Float averageNumberOfRooms;

        public RunnableDataProcessing_2(List<List<String>> data) {
                this.data = data;
        }

        public void getResults() {
                System.out.println("\n\nData processing #2");
                System.out.println(
                                "areas/blocks within the top (lowest) 10% of low crime rate and the top (lowest) 10% of pupil-teacher ratio.\n"
                                                + result);
                System.out.println("\n Highest house price :$" + Float.parseFloat(highesthouseprice) * 1000);
                System.out.println("\n Lowest house price :$" + Float.parseFloat(lowestthouseprice) * 1000);
                System.out.println("\n Average house price : $" + String.format("%.2f", averageHousePrice));
                System.out.println("\n Highest Nox Concentration: " + highestNox);
                System.out.println("\n Lowest Nox Concentration: " + lowestNox);
                System.out.println("\n Average Nox Concentarion : " + String.format("%.4f", averageNox));
                System.out.println("\n Highest Number of Rooms: " + highestNumberOfRooms);
                System.out.println("\n Lowest  Number of Rooms: " + lowestNumberOfRooms);
                System.out.println("\n Average  Number of Rooms : " + String.format("%.4f", averageNumberOfRooms));

        };

        public void run() {

                // Collections.sort(data, (a,b)->a.get(0)-b.get(0));

                List<List<String>> sorteddataByPtratioAndCrim = this.data.stream().sorted((o1, o2) -> {
                        if (o1.get(0).compareTo(o2.get(0)) == 0) {
                                return o1.get(10).compareTo(o2.get(10));
                        } else {
                                return o1.get(0).compareTo(o2.get(0));
                        }
                }).collect(Collectors.toList());
                this.result = sorteddataByPtratioAndCrim.stream().limit(10).collect(Collectors.toList());

                this.highesthouseprice = result.stream().map(item -> item.get(13))
                                .max(Comparator.comparing(price -> price)).get();

                this.lowestthouseprice = result.stream().map(item -> item.get(13))
                                .min(Comparator.comparing(price -> price)).get();

                var averageHousePriceCal = result.stream().map(
                                (item) -> item.get(13)).reduce("0", (result1, price) -> {
                                        var totalInt = Float.parseFloat(result1);
                                        var priceInt = Float.parseFloat(price) * 1000;
                                        totalInt = totalInt + priceInt;
                                        return String.valueOf(totalInt);
                                });
                this.averageHousePrice = (Float.parseFloat(averageHousePriceCal)) / result.size();

                this.highestNox = result.stream().map(item -> item.get(4))
                                .max(Comparator.comparing(price -> price)).get();

                this.lowestNox = result.stream().map(item -> item.get(4))
                                .min(Comparator.comparing(price -> price)).get();

                var averageNoxvalue = result.stream().map(
                                (item) -> item.get(4)).reduce("0", (result1, nox) -> {
                                        var totalInt = Float.parseFloat(result1);
                                        var noxInt = Float.parseFloat(nox);
                                        totalInt = totalInt + noxInt;
                                        return String.valueOf(totalInt);
                                });
                this.averageNox = (Float.parseFloat(averageNoxvalue)) / result.size();

                this.highestNumberOfRooms = result.stream().map(item -> item.get(5))
                                .max(Comparator.comparing(price -> price)).get();

                this.lowestNumberOfRooms = result.stream().map(item -> item.get(5))
                                .min(Comparator.comparing(price -> price)).get();

                var averageNumberOfRoomsvalue = result.stream().map(
                                (item) -> item.get(5)).reduce("0", (result1, room) -> {
                                        var totalInt = Float.parseFloat(result1);
                                        var roomInt = Float.parseFloat(room);
                                        totalInt = totalInt + roomInt;
                                        return String.valueOf(totalInt);
                                });

                this.averageNumberOfRooms = (Float.parseFloat(averageNumberOfRoomsvalue)) / result.size();

        }

}
