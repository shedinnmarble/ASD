package edu.mum.lab3;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Drive cdrive = new Drive("C");
        Directory appdir = new Directory("applications");
        Directory datadir = new Directory("my data");
        Directory coursedir = new Directory("cs525");
        File excelfile = new File("msexcel.exe", 2353256);
        File wordfile = new File("msword.exe", 3363858);
        File studentsfile = new File("students.doc", 34252);
        // newly add link
        Link newLink = new Link("grades.link", 123123123);
        cdrive.addFile(appdir);
        cdrive.addFile(datadir);
        datadir.addFile(coursedir);
        appdir.addFile(excelfile);
        appdir.addFile(wordfile);
        coursedir.addFile(studentsfile);
        coursedir.addFile(newLink);
        cdrive.print();
    }
}
