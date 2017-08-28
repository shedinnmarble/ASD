package edu.mum.lab3;

import java.util.List;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public class StockMarket extends AbstractMarket{

    public void addStock(String stockSymbol, Double price){
        stocklist.put(stockSymbol, price);
    }

    public void update(String stockSymbol, Double price, List<IObserver> observerList){
        stocklist.put(stockSymbol, price);
        for(IObserver observer: observerList){
            observer.update(stocklist);
        }
    }
}