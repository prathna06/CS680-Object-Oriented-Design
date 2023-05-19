package edu.umb.CS680.HW11;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class YearComparatorTest {

    List<Car> Cars = new ArrayList<Car>();
    
    @Test
    public void testYearComp(){
        Cars.add(new Car("Ford","GT5", 780,2019, 400000));
        Cars.add(new Car("Lexus","B65", 90,2018, 460000));
        Cars.add(new Car("Audi","R44", 30,2012, 700000));
        Cars.add(new Car("BMW","AX5", 780,2017, 100000));

        Collections.sort(Cars,new YearComparator());

        assertEquals(2012, Cars.get(0).getYear());
        assertEquals(2017, Cars.get(1).getYear());
        assertEquals(2018,Cars.get(2).getYear());
        assertEquals(2019, Cars.get(3).getYear());

    }
    
}