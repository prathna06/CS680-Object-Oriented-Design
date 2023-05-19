package edu.umb.CS680.HW11;
import java.util.ArrayList;

public class Car {

    private String make, model;
    private int mileage, year;
    private float price;
    private int dominationCount;

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public int getDominationCount() {
        return dominationCount;
    }

    public void setDominationCount(ArrayList<Car> usedCars) {
        int temp = 0;
        for (Car car : usedCars ) {


            if (!car.equals(this)) {
                if (this.getYear() > car.getYear()) {
                    temp = temp + 1;
                } else if (this.getYear() == car.getYear()) {
                    if (this.getMileage() < car.getMileage()) {
                        temp = temp + 1;
                    } else if (this.getMileage() == car.getMileage()) {
                        if (this.getPrice() < car.getPrice()) {
                            temp = temp + 1;
                        }
                    }
                }
            }
            
        }
        System.out.println(temp);
        this.dominationCount = temp;
    }
}