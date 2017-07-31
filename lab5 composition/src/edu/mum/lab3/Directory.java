package edu.mum.lab3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public class Directory implements IFileSystem {
    protected String name;
    protected Collection<IFileSystem> fileSystemArrayList = new ArrayList<IFileSystem>();

    public Directory(String name) {
        this.name = name;
    }
    public void print(){
        System.out.println("-- dir "+name+" size="+getSizeInBytes()+" bytes");
        for (IFileSystem dir : fileSystemArrayList){
            dir.print();
        }
    }
    public void addFile(IFileSystem file){
        fileSystemArrayList.add(file);
    }

    public int getSizeInBytes(){
        int sizeInBytes=0;
        for (IFileSystem file : fileSystemArrayList){
            sizeInBytes+=file.getSizeInBytes();
        }
        return sizeInBytes;
    }
}
