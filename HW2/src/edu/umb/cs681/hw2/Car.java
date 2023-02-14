package edu.umb.cs681.hw2;

import java.util.ArrayList;

public class Car {

    private String make;
    private String model;
    private int mileage;
    private int year;
    private int dominationCount;
    private float price;

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    	
	public String get_make()
	{
		return make;
	}
	
	public String get_model() {
		return model;
	}
	
	public int get_mileage() {
		return mileage;
	}
	
	public int get_year() {
		return year;
	}
	
	public float get_price() {
		return price;
	}

    public void setDominationCount(ArrayList<Car> cars) {
        int Dominationcount = 0;
        for (Car car : cars) {
            if (!car.equals(this)) {
                if ((this.get_year() >= car.get_year()) && (this.get_mileage() <= car.get_mileage())
                        && (this.get_price() <= car.get_price())) {
                    if ((this.get_year() > car.get_year()) || (this.get_mileage() < car.get_mileage())
                            || (this.get_price() < car.get_price())) {
                        Dominationcount++;
                    }
                }
            }
        }
        this.dominationCount = Dominationcount;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

}
