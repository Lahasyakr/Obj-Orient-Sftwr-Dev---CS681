package edu.umb.cs681.hw1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void sortByYear(List<Car> usedCars) {
        System.out.println("Sorting cars by year in an order");

        List<Car> carSortByYear = usedCars.stream()
                .sorted(Comparator.comparingInt(Car::get_year))
                .collect(Collectors.toList());
        System.out.println(
                "Year" + " " + "Make" + " " + "Model" + " " + "Price" + " "
                        + "Mileage");
        carSortByYear.forEach((Car car) -> System.out.println(
                car.get_year() + " " + car.get_make() + " " + car.get_model() + " " + car.get_price() + " "
                        + car.get_mileage()));

        System.out.println("\nGrouping using year as threshold with value 2018");

        Map<Boolean, List<Car>> carsGroupedByYearThreshold = usedCars.stream()
                .collect(Collectors.partitioningBy(
                        (Car car) -> car.get_year() > 2018));
        System.out.println("\n Group HIGH -");
        System.out.println(
                "Year" + " " + "Make" + " " + "Model" + " " + "Price" + " "
                        + "Mileage");
        carsGroupedByYearThreshold.get(true).forEach((Car car) -> {
            System.out
                    .println(car.get_year() + " " + car.get_make() + " " + car.get_model() + " " + car.get_price() + " "
                            + car.get_mileage());
        });
        System.out.println("Highest value: " + carsGroupedByYearThreshold.get(true).stream()
                .max(Comparator.comparing((Car car1) -> car1.get_year())).get().get_year());
        System.out.println("Lowest value: " + carsGroupedByYearThreshold.get(true).stream()
                .min(Comparator.comparing((Car car1) -> car1.get_year())).get().get_year());
        System.out.println("Average value: " + carsGroupedByYearThreshold.get(true).stream()
                .mapToInt((Car item) -> item.get_year()).average().getAsDouble());
        System.out.println("\n Group LOW -");
        System.out.println(
                "Year" + " " + "Make" + " " + "Model" + " " + "Price" + " "
                        + "Mileage");
        carsGroupedByYearThreshold.get(false).forEach((Car car) -> {
            System.out
                    .println(car.get_year() + " " + car.get_make() + " " + car.get_model() + " " + car.get_price() + " "
                            + car.get_mileage());
        });

        System.out.println("Highest value: " + carsGroupedByYearThreshold.get(false).stream()
                .max(Comparator.comparing((Car car1) -> car1.get_year())).get().get_year());
        System.out.println("Lowest value: " + carsGroupedByYearThreshold.get(false).stream()
                .min(Comparator.comparing((Car car1) -> car1.get_year())).get().get_year());
        System.out.println("Average value: " + carsGroupedByYearThreshold.get(false).stream()
                .mapToInt((Car item) -> item.get_year()).average().getAsDouble());
    }

    public static void sortByMileage(List<Car> usedCars) {
        System.out.println("\n\nSorting cars by mileage in an order");
        System.out.println(
                "Mileage" + " " + "Make" + " " + "Model" + " " + "Price" + " "
                        + "Year");
        List<Car> carSortByMileage = usedCars.stream()
                .sorted(Comparator.comparingInt(Car::get_mileage))
                .collect(Collectors.toList());
        carSortByMileage.forEach((Car car) -> System.out.println(
                car.get_mileage() + " " + car.get_make() + " " + car.get_model() + " " + car.get_price() + " "
                        + car.get_year()));

        System.out.println("\nGrouping using mileage as threshold with value 32");
        Map<Boolean, List<Car>> carsGroupedByMileageThreshold = usedCars.stream()
                .collect(Collectors.partitioningBy(
                        (Car car) -> car.get_mileage() > 32));
        System.out.println("\n Group HIGH -");
        System.out.println(
                "Mileage" + " " + "Make" + " " + "Model" + " " + "Price" + " "
                        + "Year");
        carsGroupedByMileageThreshold.get(true).forEach((Car car) -> {
            System.out.println(
                    car.get_mileage() + " " + car.get_make() + " " + car.get_model() + " " + car.get_price() + " "
                            + car.get_year());
        });
        System.out.println("Highest value: " + carsGroupedByMileageThreshold.get(true).stream()
                .max(Comparator.comparing((Car car1) -> car1.get_mileage())).get().get_mileage());
        System.out.println("Lowest value: " + carsGroupedByMileageThreshold.get(true).stream()
                .min(Comparator.comparing((Car car1) -> car1.get_mileage())).get().get_mileage());
        System.out.println("Average value: " + carsGroupedByMileageThreshold.get(true).stream()
                .mapToInt((Car item) -> item.get_mileage()).average().getAsDouble());
        System.out.println("\n Group LOW -");
        System.out.println(
                "Mileage" + " " + "Make" + " " + "Model" + " " + "Price" + " "
                        + "Year");
        carsGroupedByMileageThreshold.get(false).forEach((Car car) -> {
            System.out.println(
                    car.get_mileage() + " " + car.get_make() + " " + car.get_model() + " " + car.get_price() + " "
                            + car.get_year());
        });
        System.out.println("Highest value: " + carsGroupedByMileageThreshold.get(false).stream()
                .max(Comparator.comparing((Car car1) -> car1.get_mileage())).get().get_mileage());
        System.out.println("Lowest value: " + carsGroupedByMileageThreshold.get(false).stream()
                .min(Comparator.comparing((Car car1) -> car1.get_mileage())).get().get_mileage());
        System.out.println("Average value: " + carsGroupedByMileageThreshold.get(false).stream()
                .mapToInt((Car item) -> item.get_mileage()).average().getAsDouble());
    }

    public static void sortByPrice(List<Car> usedCars) {
        System.out.println("\n\nSorting cars by price in an order");
        System.out.println(
                "Price" + " " + "Make" + " " + "Model" + " " + "Mileage" + " "
                        + "Year");
        List<Car> carSortByPrice = usedCars.stream()
                .sorted(Comparator.comparingDouble(Car::get_price))
                .collect(Collectors.toList());
        carSortByPrice.forEach((Car car) -> System.out.println(
                car.get_price() + " " + car.get_make() + " " + car.get_model() + " " + car.get_mileage() + " "
                        + car.get_year()));

        System.out.println("\nGrouping using price as threshold with value 32000");

        Map<Boolean, List<Car>> carsGroupedByPriceThreshold = usedCars.stream()
                .collect(Collectors.partitioningBy(
                        (Car car) -> car.get_price() > 32000f));
        System.out.println("\n Group HIGH -");
        System.out.println(
                "Price" + " " + "Make" + " " + "Model" + " " + "Mileage" + " "
                        + "Year");
        carsGroupedByPriceThreshold.get(true).forEach((Car car) -> {
            System.out.println(
                    car.get_price() + " " + car.get_make() + " " + car.get_model() + " " + car.get_mileage() + " "
                            + car.get_year());
        });
        System.out.println("Highest value: " + carsGroupedByPriceThreshold.get(true).stream()
                .max(Comparator.comparing((Car car1) -> car1.get_price())).get().get_price());
        System.out.println("Lowest value: " + carsGroupedByPriceThreshold.get(true).stream()
                .min(Comparator.comparing((Car car1) -> car1.get_price())).get().get_price());
        System.out.println("Average value: " + carsGroupedByPriceThreshold.get(true).stream()
                .mapToDouble((Car item) -> item.get_price()).average().getAsDouble());
        System.out.println("\n Group LOW -");
        System.out.println(
                "Price" + " " + "Make" + " " + "Model" + " " + "Mileage" + " "
                        + "Year");
        carsGroupedByPriceThreshold.get(false).forEach((Car car) -> {
            System.out.println(
                    car.get_price() + " " + car.get_make() + " " + car.get_model() + " " + car.get_mileage() + " "
                            + car.get_year());
        });
        System.out.println("Highest value: " + carsGroupedByPriceThreshold.get(false).stream()
                .max(Comparator.comparing((Car car1) -> car1.get_price())).get().get_price());
        System.out.println("Lowest value: " + carsGroupedByPriceThreshold.get(false).stream()
                .min(Comparator.comparing((Car car1) -> car1.get_price())).get().get_price());
        System.out.println("Average value: " + carsGroupedByPriceThreshold.get(false).stream()
                .mapToDouble((Car item) -> item.get_price()).average().getAsDouble());
    }

    public static void sortByDominationCount(List<Car> usedCars) {
        System.out.println("\n\nSorting cars by DominationCount in an order");

        List<Car> carSortByDominationCount = usedCars.stream()
                .sorted(Comparator.comparingInt(Car::getDominationCount))
                .collect(Collectors.toList());
        System.out.println(
                "DominationCount" + " " + "Price" + " " + "Make" + " " + "Model" + " " + "Mileage" + " "
                        + "Year");
        carSortByDominationCount.forEach((Car car) -> System.out.println(
                car.getDominationCount() + " " + car.get_price() + " " + car.get_make() + " " + car.get_model() + " "
                        + car.get_mileage() + " " + car.get_year()));

        System.out.println("\nGrouping using DominationCount as threshold with value 1");

        Map<Boolean, List<Car>> carsGroupedByDCountThreshold = usedCars.stream()
                .collect(Collectors.partitioningBy(
                        (Car car) -> car.getDominationCount() > 1));
        System.out.println("\n Group HIGH -");
        System.out.println(
                "DominationCount" + " " + "Price" + " " + "Make" + " " + "Model" + " " + "Mileage" + " "
                        + "Year");
        carsGroupedByDCountThreshold.get(true).forEach((Car car) -> {
            System.out.println(
                    car.getDominationCount() + " " + car.get_price() + " " + car.get_make() + " " + car.get_model()
                            + " "
                            + car.get_mileage() + " " + car.get_year());
        });
        System.out.println("Highest value: " + carsGroupedByDCountThreshold.get(true).stream()
                .max(Comparator.comparing((Car car1) -> car1.getDominationCount())).get().getDominationCount());
        System.out.println("Lowest value: " + carsGroupedByDCountThreshold.get(true).stream()
                .min(Comparator.comparing((Car car1) -> car1.getDominationCount())).get().getDominationCount());
        System.out.println("Average value: " + carsGroupedByDCountThreshold.get(true).stream()
                .mapToDouble((Car item) -> item.getDominationCount()).average().getAsDouble());
                
        System.out.println("\n Group LOW -");
        System.out.println(
                "DominationCount" + " " + "Price" + " " + "Make" + " " + "Model" + " " + "Mileage" + " "
                        + "Year");
        carsGroupedByDCountThreshold.get(false).forEach((Car car) -> {
            System.out.println(
                    car.getDominationCount() + " " + car.get_price() + " " + car.get_make() + " " + car.get_model()
                            + " "
                            + car.get_mileage() + " " + car.get_year());
        });
        System.out.println("Highest value: " + carsGroupedByDCountThreshold.get(false).stream()
                .max(Comparator.comparing((Car car1) -> car1.getDominationCount())).get().getDominationCount());
        System.out.println("Lowest value: " + carsGroupedByDCountThreshold.get(false).stream()
                .min(Comparator.comparing((Car car1) -> car1.getDominationCount())).get().getDominationCount());
        System.out.println("Average value: " + carsGroupedByDCountThreshold.get(false).stream()
                .mapToDouble((Car item) -> item.getDominationCount()).average().getAsDouble());

    }

    public static void main(String[] args) throws Exception {
        ArrayList<Car> usedCars = new ArrayList<>();

        usedCars.add(new Car("Honda", "Accord", 34, 2022, 28000f));
        usedCars.add(new Car("Ford", "Bronco", 22, 2019, 44000f));
        usedCars.add(new Car("Kia", "K5", 32, 2021, 25000f));
        usedCars.add(new Car("Hyundai", "Sonata", 36, 2018, 32000f));
        usedCars.add(new Car("Range Rover", "Evoque", 48, 2017, 52000f));
        usedCars.add(new Car("Mazda", "CX-5", 28, 2016, 33000f));
        sortByYear(usedCars);
        sortByMileage(usedCars);
        sortByPrice(usedCars);

        usedCars.forEach((Car car) -> car.setDominationCount(usedCars)); // Setting DominationCount first
        sortByDominationCount(usedCars);

    }
}