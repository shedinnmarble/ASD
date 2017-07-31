package edu.mum.lab5;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public class Item {
    String title;
    String isbn;
    ItemType itemType;
    public Item(ItemType itemType){
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void print(){
        if(this.itemType == ItemType.BOOK){
            System.out.println(String.format("\t\tBook: title %s, isbn %s", this.getTitle(), this.getIsbn())) ;
        }else{
            System.out.println(String.format("\t\tDVD: isbn %s", this.getIsbn())) ;
        }
    }
}
