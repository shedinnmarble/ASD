package edu.mum.lab3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public class AbstractMarket {
    Map<String,Double> stocklist = new HashMap<String,Double>();
    public Map<String, Double> getStocklist() {
        return stocklist;
    }
}
