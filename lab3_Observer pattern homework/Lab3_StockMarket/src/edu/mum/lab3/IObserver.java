package edu.mum.lab3;

import java.util.Map;

/**
 * Created by dewei.xiang on 7/11/2017.
 */
public interface IObserver {
    void update(Map<String, Double> stocklist);
}
