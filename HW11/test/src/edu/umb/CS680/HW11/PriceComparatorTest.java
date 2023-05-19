package edu.umb.CS680.HW11;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PriceComparatorTest {

    List<Car> CarsList = new ArrayList<Car>();

    @Test
    public void PriceComparatrTest(){
        CarsList.add(new Car("BMW", "A7", 60,2016, 400000));
        CarsList.add(new Car("Lexus","B65", 90,2018, 460000));
        CarsList.add(new Car("Audi","R44", 30,2012, 700000));
        CarsList.add(new Car("Ford","GT5", 780,2019, 100000));

        Collections.sort(CarsList,new PriceComparator());

        assertEquals(100000, CarsList.get(0).getPrice());
        assertEquals(400000, CarsList.get(1).getPrice());
        assertEquals(460000,CarsList.get(2).getPrice());
        assertEquals(700000, CarsList.get(3).getPrice());
    }

}