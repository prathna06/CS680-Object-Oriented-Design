package edu.umb.CS680.HW10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    private static List<Double> p1, p2, p3, p4, p5,p6;
    private static List<List<Double>> points = new LinkedList<>();
    @BeforeAll
    static void createListOfPoints(){
        p1 = Arrays.asList(1.0, 2.0, 3.0);
        p2 = Arrays.asList(4.0, 5.0, 6.0);
        p3 = Arrays.asList(7.0, 8.0, 9.0);
        p4 = Arrays.asList(3.0, 2.0, 1.0);
        p5 = Arrays.asList(6.0, 5.0, 4.0);
        p6 =Arrays.asList(5.0,7.0,9.0,10.0);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p5);

        points = DatasetNormalization.normalizeDataset(points);
        
    }



    @Test
    public void distForTwoPoints() {
        double actual = Distance.get(p1, p2);
        assertEquals(Math.sqrt(27.0), actual);
    }

    @Test
    public void testForEuclideanDist() {
        double actual = Distance.get(p1, p2, new Euclidean());
        assertEquals(Math.sqrt(27.0), actual);
    }
    @Test
    public void testForEuclideanDistForDiffPoints() {
        double actual = Distance.get(p1, p6, new Euclidean());

    }

    @Test
    public void testForManhattanDist() {
        double actual = Distance.get(p1, p2, new Manhattan());
        assertEquals(9.0, actual);
    }


    @Test
    public void euclideanMatrix() {
         Double[][] expectedDistance = {
              { 0.0, Math.sqrt(0.64), Math.sqrt(2.56), Math.sqrt(0.16), Math.sqrt(0.81) },
               { Math.sqrt(0.64), 0.0, Math.sqrt(0.64), Math.sqrt(0.64), Math.sqrt(0.16) },
               { Math.sqrt(2.56), Math.sqrt(0.64), 0.0, Math.sqrt(2.56), Math.sqrt(0.64) },
               { Math.sqrt(0.16), Math.sqrt(0.64), Math.sqrt(2.65), 0.0, Math.sqrt(0.64) },
               { Math.sqrt(0.81), Math.sqrt(0.16), Math.sqrt(0.64), Math.sqrt(0.64), 0.0 } };


            for (int i = 0; i < expectedDistance.length; i++) {
                for (int j = 0; j < expectedDistance[i].length; j++) {
                    expectedDistance[i][j] = Math.round(expectedDistance[i][j] * 10.0) / 10.0;
                }
            }

        
           List<List<Double>> actualDistance = Distance.matrix(points);

           for (List<Double> row : actualDistance) {
               for (int i = 0; i < row.size(); i++) {
                   double value = row.get(i);
                   row.set(i, Math.round(value * 10.0) / 10.0);
               }
           }
           System.out.println(actualDistance+"actual");
    

        for (int i = 0; i < expectedDistance.length; i++) {
            Double[] temp = new Double[5];
           assertArrayEquals(expectedDistance[i], actualDistance.get(i).toArray(temp));

        }
    }

    @Test
    public void manhattanMatrix() {

           Double [][] expectedDistance = 

           {{0.0, 1.3, 2.7, 0.6, 1.4}
           , {1.3, 0.0, 1.4, 1.3, 0.5}, 
           {2.7, 1.4, 0.0, 2.7, 1.3}, 
           {0.6, 1.3, 2.7, 0.0, 1.4}, 
           {1.4, 0.5, 1.3, 1.4, 0.0}};
            
            for (int i = 0; i < expectedDistance.length; i++) {
                for (int j = 0; j < expectedDistance[i].length; j++) {
                    expectedDistance[i][j] = Math.round(expectedDistance[i][j] * 10.0) / 10.0;
                }
            }
           System.out.println(expectedDistance+"exp");

        
           List<List<Double>> actualDistance = Distance.matrix(points,new Manhattan());

           for (List<Double> row : actualDistance) {
               for (int i = 0; i < row.size(); i++) {
                   double value = row.get(i);
                   row.set(i, Math.round(value * 10.0) / 10.0);
               }
           }
           System.out.println(actualDistance+"actual");
    

        for (int i = 0; i < expectedDistance.length; i++) {
            Double[] temp = new Double[5];
           assertArrayEquals(expectedDistance[i], actualDistance.get(i).toArray(temp));

        }
    }
        
    }

  