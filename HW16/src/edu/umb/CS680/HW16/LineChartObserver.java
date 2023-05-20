package edu.umb.CS680.HW16;

public class LineChartObserver implements Observer{
    @Override
    public void update(Observable sender, Object o) {
        System.out.println("StockEvent LineChart Updated");
    }


}