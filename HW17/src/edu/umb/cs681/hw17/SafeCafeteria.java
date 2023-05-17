package edu.umb.cs681.hw17;
import java.util.concurrent.locks.ReentrantLock;

public class SafeCafeteria {
    private static ReentrantLock coffeeLock = new ReentrantLock();
    private static ReentrantLock waterLock = new ReentrantLock();

    public void demo(String[] args) {

        System.out.println("\n\n****** SafeCafeteria - deadlock solved by using locks in an order *****");

        Thread thread1 = new Thread(() -> {
            coffeeLock.lock();
            System.out.println("Safe cafe - Thread 1: Got coffee machine lock and making coffee");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Safe cafe - Thread 1: Filling water while holding the coffee machine lock");
            waterLock.lock();
            System.out.println("Safe cafe - Thread 1: Got water dispenser lock and filling water- This is Thread safe");
            waterLock.unlock();
            coffeeLock.unlock();
        });

        Thread thread2 = new Thread(() -> {
            coffeeLock.lock(); // acquire coffeeLock first
            System.out.println("Safe cafe - Thread 2: Making coffee while holding the coffee machine lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Safe cafe - Thread 2: Filling water while holding the coffee machine lock");
            waterLock.lock();
            System.out.println("Safe cafe - Thread 2: Got water dispenser lock and filling water - This is Thread safe");
            waterLock.unlock();
            coffeeLock.unlock();
        });

        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
