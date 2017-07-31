package edu.mum.lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public class Category implements ICategory {
    List<ICategory> categoryList = new ArrayList<>();
    List<Item> itemList =new ArrayList<>();
    String categoryName;
    public Category(String categoryName){
        this.categoryName = categoryName;
    }
    @Override
    public void add(ICategory category) {
        categoryList.add(category);
    }

    @Override
    public void addItem(Item item) {
        this.itemList.add(item);
    }

    @Override
    public void print() {
        System.out.println(String.format("this is %s category.", this.categoryName));
        for(ICategory category: categoryList){
            System.out.println(String.format("\t %s has %s category", this.categoryName,category.getCategoryName()));
            for(Item item: category.getItemList()){
                item.print();
            }
        }
    }
    public String getCategoryName(){
        return this.categoryName;
    }

    public List<Item> getItemList() {
        return itemList;
    }
}
