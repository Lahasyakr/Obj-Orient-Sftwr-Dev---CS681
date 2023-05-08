package edu.umb.cs681.hw14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AdmissionMonitor {
    private int currentVisitors;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Condition maxVisitorCondition = lock.writeLock().newCondition();

    public int countCurrentVisitors() {
        lock.readLock().lock();
        try {
            System.out.println("current visitors count:  " + this.currentVisitors);
            return this.currentVisitors;
        } finally {
            lock.readLock().unlock();
        }

    }

    public void enter() throws InterruptedException {
        lock.writeLock().lock();
        try {
            while (this.currentVisitors > 10) {
                System.out.println("Too many visitors. Please wait for a while!");
                this.maxVisitorCondition.await();
            }
            this.currentVisitors++;
            System.out.println("Visitor Enters - Count:  " + this.currentVisitors);
        } finally {
            lock.writeLock().unlock();
        }

    }

    public void exit() {
        lock.writeLock().lock();
        try {
            if (this.currentVisitors > 0) {
                this.currentVisitors--;
                System.out.println("Visitor Exits - Count:  " + this.currentVisitors);
                this.maxVisitorCondition.signalAll();
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

}
