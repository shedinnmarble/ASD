package edu.mum.lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public class ProductCatalog {
    List<ICategory> categoryList = new ArrayList<>();
    public void addCategory(ICategory category){
        this.categoryList.add(category);
    }
    public void print(){
        for(ICategory category: categoryList){
            category.print();
        }
    }
}
