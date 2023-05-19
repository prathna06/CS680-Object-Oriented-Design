package edu.umb.CS680.HW11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}