package edu.umb.CS680.HW16;

public class TableChartObserver implements Observer{

    public StockEvent event = new StockEvent("abc", 4.5);

    @Override
    public void update(Observable sender, Object o) {
        event.getTicker();
        event.getQuote();
        System.out.println("StockEvent TableChart Updated");
    }
}