package edu.umb.cs681.hw2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> usedCars = new ArrayList<>();

        usedCars.add(new Car("Honda", "Accord", 34, 2022, 28000f));
        usedCars.add(new Car("Ford", "Bronco", 22, 2019, 44000f));
        usedCars.add(new Car("Kia", "K5", 32, 2021, 25000f));
        usedCars.add(new Car("Hyundai", "Sonata", 36, 2018, 32000f));
        usedCars.add(new Car("Range Rover", "Evoque", 48, 2017, 52000f));
        usedCars.add(new Car("Mazda", "CX-5", 28, 2016, 32000f));

        System.out.println("\ncalculating average price of the car using class instance");
        double averagePrice = usedCars.stream()
                .map((car) -> car.get_price()).reduce(new CarPriceResultHolder(),
                        (result, price) -> {
                            // System.out.println(result.getNumCarExamined() + " "+ result.getAverage() +" "
                            // + price);
                            CarPriceResultHolder resultHolder = result;
                            int numCarExamined = (int) resultHolder.getNumCarExamined();
                            double average = resultHolder.getAverage();
                            float r = (float) (((numCarExamined * average) + price) / (numCarExamined + 1));
                            resultHolder.setNumCarExamined(numCarExamined + 1);
                            resultHolder.setAverage(r);
                            // System.out.println(resultHolder.getAverage() + " " +
                            // resultHolder.getNumCarExamined());
                            return resultHolder;
                        },
                        (finalResult, intermediateResult) -> finalResult)
                .getAverage();

        System.out.println("average car price  : " + averagePrice);

        List<Car> carSortByPrice = usedCars.stream()
                .sorted(Comparator.comparingDouble(Car::get_price)).collect(Collectors.toList());

        System.out.println("lowest car price :" + carSortByPrice.get(0).get_price());

        System.out.println("Highest Car price :" + carSortByPrice.get(carSortByPrice.size() - 1).get_price());

    }
}
