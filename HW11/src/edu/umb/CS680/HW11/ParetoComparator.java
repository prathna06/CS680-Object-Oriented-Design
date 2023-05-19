package edu.umb.CS680.HW11;


import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        return (o1.getDominationCount()- o2.getDominationCount());
    }
}