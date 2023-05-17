package edu.umb.cs681.hw17;

import java.util.concurrent.locks.ReentrantLock;

public class NotSafeCafeteria {
    private static ReentrantLock coffeeLock = new ReentrantLock();
    private static ReentrantLock waterLock = new ReentrantLock();

    public void demo(String[] args) {

        System.out.println("\n\n***** NotSafeCafeteria - Which causes the potential deadlock *****");

        Thread thread1 = new Thread(() -> {
            coffeeLock.lock();
            System.out.println("No Safe cafe -Thread 1: Got coffee machine lock and making coffee");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("No Safe cafe - Thread 1: Trying to acquire water dispenser lock while holding the coffee machine lock");
            waterLock.lock();
            System.out.println("No Safe cafe - Thread 1: Got water dispenser lock and filling water");
            waterLock.unlock();
            coffeeLock.unlock();
        });

        Thread thread2 = new Thread(() -> {
            waterLock.lock();
            System.out.println("No Safe cafe - Thread 2: Got water dispenser lock and filling water");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("No Safe cafe -Thread 2: Trying to acquire coffee machine lock while holding the water dispenser lock");
            coffeeLock.lock();
            System.out.println("No Safe cafe - Thread 2: Got coffee machine lock and making coffee");
            coffeeLock.unlock();
            waterLock.unlock();
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        // If the threads are deadlocked, interrupt one of them to terminate it
        if (thread1.isAlive() && thread2.isAlive()) {
            System.out.println("No Safe cafe - Deadlock detected. Terminating thread 1 & thread 2");
            thread1.interrupt();
            System.exit(0); // Terminate the program
        }
      
    }

}
