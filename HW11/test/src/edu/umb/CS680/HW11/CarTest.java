package edu.umb.CS680.HW11;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private String[] carToStringArray(Car car){
        String[] strarr = {car.getMake(), car.getModel(), String.valueOf(car.getMileage()), String.valueOf(car.getYear()), String.valueOf(car.getPrice())};
        return(strarr);
    }

    @Test
    public void carEqualityWithMakeModelTest(){
        String[] expected = new String[]{"lexus", "RX350","70","2017","1200000.0"};
        Car actual = new Car("lexus", "RX350",70,2017, 1200000);
        assertArrayEquals(expected, carToStringArray(actual));

    }

    @Test
    public void diffrentCarInstanceTest(){
        Car expected = new Car("lexus", "RX350",70,2017, 1200000);
        Car actual = new Car("lexus", "RX350",70,2017, 1200000);
        assertNotSame(expected, (actual));
    }

}