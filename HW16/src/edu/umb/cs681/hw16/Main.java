package edu.umb.cs681.hw16;

public class Main {
    public static void main(String[] args) {

        System.out.println("##### Not Thread safe cart and customer class execution #####");
        NotThreadSafeCart cart = new NotThreadSafeCart();

        Customer customer1 = new Customer(cart);
        Customer customer2 = new Customer(cart);
        Customer customer3 = new Customer(cart);

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



        System.out.println("\n\n*** Thread safe cart and customer class execution ****");
        ThreadSafeCart safeCart = new ThreadSafeCart();

        Customer threadsafeCustomer1 = new Customer(safeCart);
        Customer threadsafeCustomer2 = new Customer(safeCart);
        Customer threadsafeCustomer3 = new Customer(safeCart);

        Thread t1 = new Thread(threadsafeCustomer1);
        Thread t2 = new Thread(threadsafeCustomer2);
        Thread t3 = new Thread(threadsafeCustomer3);

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       

    }
}
