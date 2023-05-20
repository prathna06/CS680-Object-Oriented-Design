package edu.umb.CS680.HW16;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class StockQuoteObeservableTest {

    private StockQuoteObservable stockQuoteObservable;
    private TableChartObserver tableChartObserver;
    private ThreeDObserver threeDObserver;
    private LineChartObserver lineChartObserver;
   private double initialQuote ;
    @Before
    public void setup() {
        stockQuoteObservable = new StockQuoteObservable();
        tableChartObserver = new TableChartObserver();
        threeDObserver = new ThreeDObserver();
        lineChartObserver = new LineChartObserver();
        stockQuoteObservable.addObserver(tableChartObserver);
        stockQuoteObservable.addObserver(threeDObserver);
        stockQuoteObservable.addObserver(lineChartObserver);
    }

    @Test
    public void TestQuoteChangeNotification1() {
        // Initial quote value
         initialQuote = 10.0;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        stockQuoteObservable.changeQuote("ABC", initialQuote);
        String actual = outputStream.toString().trim();
        String expectedOutput = "StockEvent TableChart Updated\nStockEvent ThreeDChart Updated\nStockEvent LineChart Updated\nObserver updated";

        // Verify that the observers received the second notification
        assertEquals(expectedOutput, actual);
        

    }

    @Test
    public void STOCKTestwithLE() {
        stockQuoteObservable.addObserver((sender, event) -> System.out.println("StockEvent LineChart Updated"));
        stockQuoteObservable.addObserver((sender, event) -> System.out.println("StockEvent TableChart Updated"));
        stockQuoteObservable.addObserver((sender, event) -> System.out.println("StockEvent ThreeDChart Updated"));
        stockQuoteObservable.changeQuote("CHE", 10.0);
        stockQuoteObservable.removeObserver((sender, event) -> System.out.println("StockEvent LineChart Updated"));
        stockQuoteObservable.removeObserver((sender, event) -> System.out.println("StockEvent TableChart Updated"));
        stockQuoteObservable.removeObserver((sender, event) -> System.out.println("StockEvent ThreeDChart Updated"));
    }




}
