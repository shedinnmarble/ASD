package edu.mum.lab3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public class Drive {
    protected String name;
    protected Collection<IFileSystem> fileSystemArrayList = new ArrayList<IFileSystem>();
    public Drive(String name) {
        this.name = name;
    }
    public void addFile(IFileSystem file){
        fileSystemArrayList.add(file);
    }



    public int computeSize(){
        int sizeInBytes=0;
        for (IFileSystem file : fileSystemArrayList){
            sizeInBytes+=file.getSizeInBytes();
        }
        return sizeInBytes;
    }
    public void print(){
        System.out.println("- drive "+name);
        // print all of them
       for(IFileSystem all: fileSystemArrayList){
           all.print();
       }
    }
}
