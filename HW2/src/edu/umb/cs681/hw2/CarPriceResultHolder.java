package edu.umb.cs681.hw2;

public class CarPriceResultHolder {
    private int numCarExamined;
    private double average;

    public CarPriceResultHolder() {
        this.numCarExamined = 0;
        this.average = 0;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double item){
        this.average = item;
    }
    public double getNumCarExamined() {
        return numCarExamined;
    }
    public void setNumCarExamined(int item){
        this.numCarExamined = item;
    }

}