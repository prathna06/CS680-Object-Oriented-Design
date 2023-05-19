package edu.umb.CS680.HW11;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ParetoComparatorTest {

    ArrayList<Car> Cars = new ArrayList<Car>();

    @Test
    public void testParetoComp(){
        Cars.add(new Car("Hyundai", "A7", 70,2012, 400000));
        Cars.add(new Car("Mercedes","B65", 50,2014, 460000));
        Cars.add(new Car("Ferrari","R44", 60,2016, 700000));
        Cars.add(new Car("Honda","GT5", 40,2018, 10000));

        for(Car car: Cars){
            car.setDominationCount(Cars);
        }

        Collections.sort(Cars,new ParetoComparator());

        assertEquals("Hyundai", Cars.get(0).getMake());
        assertEquals("Mercedes", Cars.get(1).getMake());
        assertEquals("Ferrari",Cars.get(2).getMake());
        assertEquals("Honda", Cars.get(3).getMake());
    }

}