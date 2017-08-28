package edu.mum.lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        IObserver buyer = new StockBuyer();
        IObserver viewer = new StockViewer();
        // create observer list
        List<IObserver> observerList = new ArrayList<>();
        observerList.add(buyer);
        observerList.add(viewer);
        market.addStock("ORC", 12.23);
        market.addStock("MSC", 45.78);

        // update
        market.update("ORC", 12.34, observerList);
        market.update("MSC", 44.68, observerList);
    }
}
