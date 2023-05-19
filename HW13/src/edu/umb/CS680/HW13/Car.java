package edu.umb.CS680.HW13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

    public void setDominationCount(List<Car> cars) {
        int x = 0;
        for (Car car : cars) {
            if (!car.equals(this)) {
                if ((this.getYear() >= car.getYear()) &&
                        (this.getMileage() <= car.getMileage()) &&
                        (this.getPrice() <= car.getPrice())) {

                    if ((this.getYear() > car.getYear()) ||
                            (this.getMileage() < car.getMileage()) ||
                            (this.getPrice() < car.getPrice())) {
                        x = x + 1;
                    }
                }
            }
        }
        this.dominationCount = x;
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "A7", 60, 2016, 900000));
        cars.add(new Car("Lexus", "B65", 90, 2018, 850000));
        cars.add(new Car("Audi", "R44", 30, 2012, 5600000));
        cars.add(new Car("Ford", "GT5", 70, 2019, 80000));

        // Sort cars by mileage using Lambda Expression
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
        System.out.println("Sorted cars by mileage:");
        for (Car car : cars) {
            System.out.println(car.getMake() + " - " + car.getMileage());
        }

        // Sort cars by domination count using Lambda Expression
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));
        System.out.println("\nSorted cars by domination count:");
        for (Car car : cars) {
            System.out.println(car.getMake() + " - " + car.getDominationCount());
        }

        // Sort cars by price using Lambda Expression
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
        System.out.println("\nSorted cars by price:");
        for (Car car : cars) {
            System.out.println(car.getMake() + " - " + car.getPrice());
        }

        // Sort cars by year using Lambda Expression
        Collections.sort(cars, Comparator.comparingInt(Car::getYear));
        System.out.println("\nSorted cars by year:");
        for (Car car : cars) {
            System.out.println(car.getMake() + " - " + car.getYear());
        }
    }
}