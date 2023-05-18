package edu.umb.cs681.hw16;

public class Student implements Runnable {
    private Library library;

    public Student(Library library) {
        this.library = library;
    }

    public void run() {
       for (int i = 0; i < 5; i++) {
            library.addBook();
        }

        library.removeBook();
    }

}