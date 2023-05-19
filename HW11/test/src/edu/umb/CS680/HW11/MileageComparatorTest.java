package edu.umb.CS680.HW11;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MileageComparatorTest {

    List<Car> CarsList = new ArrayList<Car>();

    @Test
    public void testMileageComp(){
        CarsList.add(new Car("BMW", "A7", 60,2016, 900000));
        CarsList.add(new Car("Lexus","B65", 90,2018, 850000));
        CarsList.add(new Car("Audi","R44", 30,2012, 5600000));
        CarsList.add(new Car("Ford","GT5", 70,2019, 80000));

        Collections.sort(CarsList,new MileageComparator());

        int[] expMilegae = new int[]{30, 60, 70, 90};
        int[] actMileage = new int[]{CarsList.get(0).getMileage(),
                                     CarsList.get(1).getMileage(),
                                     CarsList.get(2).getMileage(),
                                     CarsList.get(3).getMileage() };
        assertArrayEquals(expMilegae, actMileage);


    }

}