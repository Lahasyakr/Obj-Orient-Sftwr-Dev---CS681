package edu.umb.cs681.hw16;


public class NotThreadSafeLibrary implements Library {
    private int books = 0;

    public void addBook() {
        books++;
        System.out.println("Book returned to library : total books in library : " + books);
    }

    public void removeBook() {
        books--;
        System.out.println("Book borrowed from library : total books in library : " + books);
    }

    public int getBooks() {
        return books;
    }

}