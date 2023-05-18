package edu.umb.CS680.HW10;

import java.util.List;

public class Manhattan implements DistanceMetric{



    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double ManhatDistance = 0;
        for(int i = 0 ; i<p1.size(); i++){
            ManhatDistance = ManhatDistance + Math.abs(p1.get(i) - p2.get(i));
        }

        return ManhatDistance;
    }

}