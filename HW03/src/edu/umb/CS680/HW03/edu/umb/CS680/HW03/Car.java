package edu.umb.CS680.HW03;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    public Car(String make, String model, int year, int mileage, float price)
    {
        this.year = year;
        this.model = model;
        this.make = make;
        this.mileage = mileage;
        this.price = price;
    }

    public Car(String make, String model, int year) {
        this.year = year;
        this.model = model;
        this.make = make;
    }

    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }


    public int getMileage(){
        return mileage;
    }
    public int getYear(){
        return year;
    }
    public float getPrice(){
        return price;
    }

    public static void main(String[] args) {

    }
}
