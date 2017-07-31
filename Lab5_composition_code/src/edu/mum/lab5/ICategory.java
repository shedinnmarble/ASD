package edu.mum.lab5;

import java.util.List;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public interface ICategory {
    void add(ICategory category);
    void addItem(Item item);
    void print();
    String getCategoryName();
    List<Item> getItemList();
}
