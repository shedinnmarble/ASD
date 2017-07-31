package edu.mum.lab3;

/**
 * Created by Dewei Xiang on 7/23/2017.
 */
public class File implements IFileSystem {
    private String name;
    private int sizeInBytes;

    public File(String name, int sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }
    public void print() {
        System.out.println("--- file " + name + " size=" + getSizeInBytes() + " bytes");
    }
    @Override
    public int getSizeInBytes() {
        return sizeInBytes;
    }
}
