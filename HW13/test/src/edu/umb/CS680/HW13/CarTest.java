 package edu.umb.CS680.HW13;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private List<Car> cars;

    @BeforeEach
    public void init() {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", "A7", 60, 2016, 900000));
        cars.add(new Car("Lexus", "B65", 90, 2018, 850000));
        cars.add(new Car("Audi", "R44", 30, 2012, 560000));
        cars.add(new Car("Ford", "GT5", 70, 2019, 80000));
    }

    @Test
    public void priceTestAscending() {
        Collections.sort(cars, Comparator.comparingDouble(Car::getPrice));
        assertEquals(cars.get(0).getMake(), "Ford");
        assertEquals(cars.get(3).getMake(), "BMW");
    }

    @Test
    public void yearTestAscending() {
        Collections.sort(cars, Comparator.comparingInt(Car::getYear));
        assertEquals(cars.get(0).getMake(), "Audi");
        assertEquals(cars.get(3).getMake(), "Ford");
    }

    @Test
    public void mileageTestAscending() {
        Collections.sort(cars, Comparator.comparingInt(Car::getMileage));
        assertEquals(cars.get(0).getMake(), "Audi");
        assertEquals(cars.get(3).getMake(), "Lexus");
    }

    @Test
    public void paretotestAscending() {
        for (Car car : cars) {
            car.setDominationCount(cars);
        }
        Collections.sort(cars, Comparator.comparingInt(Car::getDominationCount));
        assertEquals(cars.get(0).getMake(), "BMW");
        assertEquals(cars.get(3).getMake(), "Ford");
    }
    
    @Test
    public void customSortingTest() {
        // Sort based on a custom criteria using lambda expression
        Collections.sort(cars, (car1, car2) -> {
            if (car1.getMake().equals(car2.getMake())) {
                return car1.getModel().compareTo(car2.getModel());
            } else {
                return car1.getMake().compareTo(car2.getMake());
            }
        });

        assertEquals(cars.get(0).getMake(), "Audi");
        assertEquals(cars.get(0).getModel(), "R44");
        assertEquals(cars.get(3).getMake(), "Lexus");
        assertEquals(cars.get(3).getModel(), "B65");
    }
}
