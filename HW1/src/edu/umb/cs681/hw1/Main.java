package edu.umb.cs681.hw1;

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
        usedCars.add(new Car("Mazda", "CX-5", 28, 2016, 33000f));

        System.out.println("Sorting cars by year in an order");
        List<Car> carSortByYear = usedCars.stream()
                .sorted(Comparator.comparingInt(Car::get_year))
                .collect(Collectors.toList());
                carSortByYear.forEach((Car car) -> System.out.println(
                    car.get_year() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_price()+" "+ car.get_mileage()
                ));

        System.out.println("\nSorting cars by year in reverse order");
        List<Car> carReverse_SortByYear = usedCars.stream()
                .sorted((Car car1, Car car2) -> car2.get_year() - car1.get_year())
                .collect(Collectors.toList());
                carReverse_SortByYear.forEach((Car car) -> System.out.println(
                    car.get_year() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_price()+" "+ car.get_mileage()
                ));

        System.out.println("\n\nSorting cars by mileage in an order");
        List<Car> carSortByMileage = usedCars.stream()
                .sorted(Comparator.comparingInt(Car::get_mileage))
                .collect(Collectors.toList());
                carSortByMileage.forEach((Car car) -> System.out.println(
                    car.get_mileage() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_price()+" "+ car.get_year())
                );

        System.out.println("\nSorting cars by mileage in reverse order");
        List<Car> carReverse_SortByMileage = usedCars.stream()
                .sorted((Car car1, Car car2) -> car2.get_mileage() - car1.get_mileage())
                .collect(Collectors.toList());
                carReverse_SortByMileage.forEach((Car car) -> System.out.println(
                    car.get_mileage() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_price()+" "+ car.get_year())
                );

        System.out.println("\n\nSorting cars by price in an order");
        List<Car> carSortByPrice = usedCars.stream()
                .sorted(Comparator.comparingDouble(Car::get_price))
                .collect(Collectors.toList());
                carSortByPrice.forEach((Car car) -> System.out.println(
                    car.get_price() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_mileage()+" "+ car.get_year())
                );

        System.out.println("\nSorting cars by price in reverse order");
        List<Car> carReverse_SortByPrice = usedCars.stream()
                .sorted((Car car1, Car car2) -> Math.round(car2.get_price() - car1.get_price()))
                .collect(Collectors.toList());
                carReverse_SortByPrice.forEach((Car car) -> System.out.println(
                    car.get_price() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_mileage()+" "+ car.get_year())
                );

        System.out.println("\n\nSorting cars by domination count in an order");
        usedCars.forEach((Car car) -> car.setDominationCount(usedCars)); // Setting domination count first

        List<Car> carSortByDominationCount = usedCars.stream()
                .sorted(Comparator.comparingInt(Car::getDominationCount))
                .collect(Collectors.toList());
                carSortByDominationCount.forEach((Car car) -> System.out.println(
                    car.getDominationCount() +" " +car.get_price() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_mileage()+" "+ car.get_year())
                );

        System.out.println("\nSorting cars by domination count in Reverse order");
        List<Car> carReverseSortByDominationCount = usedCars.stream()
                .sorted((Car car1, Car car2) -> car2.getDominationCount() - car1.getDominationCount())
                .collect(Collectors.toList());
                carReverseSortByDominationCount.forEach((Car car) -> System.out.println(
                    car.getDominationCount() +" " +car.get_price() +" "+ car.get_make() +" " +car.get_model() + " " +  car.get_mileage()+" "+ car.get_year())
                );
    }
}