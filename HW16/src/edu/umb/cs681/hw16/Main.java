package edu.umb.cs681.hw16;

public class Main {
    public static void main(String[] args) {

        System.out.println("##### Not Thread safe library class execution #####");
        NotThreadSafeLibrary library = new NotThreadSafeLibrary();

        Student customer1 = new Student(library);
        Student customer2 = new Student(library);
        Student customer3 = new Student(library);

        Thread thread1 = new Thread(customer1);
        Thread thread2 = new Thread(customer2);
        Thread thread3 = new Thread(customer3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("\n\n*** Thread safe library class execution ****");
        ThreadSafeLibrary safeLibrary = new ThreadSafeLibrary();

        Student threadsafeStudent1 = new Student(safeLibrary);
        Student threadsafeStudent2 = new Student(safeLibrary);
        Student threadsafeStudent3 = new Student(safeLibrary);

        Thread t1 = new Thread(threadsafeStudent1);
        Thread t2 = new Thread(threadsafeStudent2);
        Thread t3 = new Thread(threadsafeStudent3);

        t1.start();
        t2.start();
        t3.start();
    
       

    }
}
