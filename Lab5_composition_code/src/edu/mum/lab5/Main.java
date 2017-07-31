package edu.mum.lab5;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ProductCatalog catalog = new ProductCatalog();
        ICategory bookCategory = new Category("BookCategory");
        ICategory dvdCategory = new Category("DVDCategory");
        ICategory fictionCategory = new Category("FictionCategory");
        ICategory computerCategory = new Category("ComputerCategory");
        ICategory drama = new Category("Drama");
        ICategory action = new Category("Action");

        Item book = new Item(ItemType.BOOK);
        book.setTitle("ASD");
        book.setIsbn("bookIsbn123");

        Item dvd = new Item(ItemType.DVD);
        dvd.setIsbn("dvdISBN345");

        catalog.addCategory(bookCategory);
        catalog.addCategory(dvdCategory);

        bookCategory.add(fictionCategory);
        bookCategory.add(computerCategory);

        fictionCategory.addItem(book);
        action.addItem(dvd);
        dvdCategory.add(drama);
        dvdCategory.add(action);


        catalog.print();
    }
}
