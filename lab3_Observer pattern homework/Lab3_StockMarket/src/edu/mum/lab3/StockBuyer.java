package edu.mum.lab3;

import java.util.Iterator;
import java.util.Map;
import java.util.Observer;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public class StockBuyer implements IObserver{
    private AbstractMarket stockMarket;
    public void update(Map<String, Double> stocklist) {
        System.out.println("StockBuyer: stocklist is changed:");
        Iterator iter = stocklist.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            Double value = (Double) entry.getValue();
            System.out.println(key + " - $" + value);
        }
    }
}