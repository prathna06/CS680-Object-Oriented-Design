package edu.umb.CS680.HW10;
//import java.util.List;
//
//public class Euclidean implements DistanceMetric{
//
//    double EucliDistance = 0;
//    @Override
//    public double distance(List<Double> p1, List<Double> p2) {
//        double sum = 0;
//        for(int i = 0 ; i<p1.size(); i++){
//            sum = sum + Math.pow(p1.get(i) - p2.get(i), 2);
//        }
//        EucliDistance = Math.sqrt(sum);
//        return EucliDistance;
//    }
//}

import java.util.List;

public class Euclidean implements DistanceMetric {
	public double distance(List<Double> p1, List<Double> p2) {
		try {
			if (p1.size() != p2.size()) {
				throw new IllegalArgumentException("Points must have the same number of dimensions");
			}

			double sumOfSquared = 0.0;
			for (int i = 0; i < p1.size(); i++) {
				sumOfSquared += Math.pow(p1.get(i) - p2.get(i), 2);
			}
			return Math.sqrt(sumOfSquared);
		} catch (IllegalArgumentException e) {
			// Handle the exception here
			System.out.println("Error: " + e.toString());
			return -1;
		}
	}
}
