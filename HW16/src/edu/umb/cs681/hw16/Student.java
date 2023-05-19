package edu.umb.cs681.hw16;

public class Student implements Runnable {
    private Library library;

    private volatile boolean done = false;

    public void setDone() {
        done = true;
    }

    public Student(Library library) {
        this.library = library;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            if (done) {
                System.out.println("As done = true Exit!!");
                break;
            }
            library.addBook();
            if (i%2 == 0) {
                library.removeBook();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }
        }

    }

}