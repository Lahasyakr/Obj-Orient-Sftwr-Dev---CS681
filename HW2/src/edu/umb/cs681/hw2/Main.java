package edu.umb.cs681.hw2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Car> usedCars = new ArrayList<>();

        usedCars.add(new Car("Honda", "Accord", 34, 2022, 28000f));
        usedCars.add(new Car("Ford", "Bronco", 22, 2019, 44000f));
        usedCars.add(new Car("Kia", "K5", 32, 2021, 25000f));
        usedCars.add(new Car("Hyundai", "Sonata", 36, 2018, 32000f));
        usedCars.add(new Car("Range Rover", "Evoque", 48, 2017, 52000f));
        usedCars.add(new Car("Mazda", "CX-5", 28, 2016, 32000f));

       
        double lowestCarPrice = usedCars.stream()
                                .map((car)-> car.get_price()).reduce((float) 0,
                                (result,price)->{
                                        if(result == 0){
                                            result = price;
                                        }
                                        else if(price < result){
                                            result = price;
                                        }
                                    return result;
                                });
        System.out.println("lowest car price :" + lowestCarPrice);

        double highestCarPrice = usedCars.stream()
        .map((car)-> car.get_price()).reduce((float) 0,
        (result,price)->{
                if(result == 0){
                    result = price;
                }
                else if(price > result){
                    result = price;
                }
            return result;
        });

        System.out.println("Highest Car price :" + highestCarPrice);


        System.out.println("calculating average price of the car");
        double averagePrice = usedCars.stream()
                .map((car) -> car.get_price()).reduce(new CarPriceResultHolder(),
                        (result, price) -> {
                            //System.out.println(result.getNumCarExamined() + " "+ result.getAverage() +" " + price);
                            CarPriceResultHolder resultHolder = result;
                            int numCarExamined = (int) resultHolder.getNumCarExamined();
                            double average = resultHolder.getAverage();
                            float r = (float) (((numCarExamined * average) + price) / (numCarExamined + 1));
                            resultHolder.setNumCarExamined(numCarExamined + 1);
                            resultHolder.setAverage(r);
                            //System.out.println(resultHolder.getAverage() + " " + resultHolder.getNumCarExamined());
                            return resultHolder;
                        },
                        (finalResult, intermediateResult) -> finalResult)
                .getAverage();

        System.out.println("average car price  : " + averagePrice);

    }
}
