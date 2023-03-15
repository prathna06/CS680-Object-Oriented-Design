package edu.umb.CS680.HW03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CarTest {
    private String[] CarToStringArray(Car car){
        String[] carInfo =
                {
                        car.getMake(), car.getModel(), Integer.toString(car.getYear())
                };
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 2018);
        assertArrayEquals(expected, CarToStringArray(actual));
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear_NotEqual() {
        String[] expected = {"Cadillac", "123", "1991"};
        Car actual = new Car("RR", "phtm", 1980);
        assertNotEquals(expected, CarToStringArray(actual));
    }

    public static void main(String[] args) {

    }
}


