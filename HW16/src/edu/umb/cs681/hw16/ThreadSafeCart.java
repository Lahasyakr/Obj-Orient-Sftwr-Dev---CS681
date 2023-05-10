package edu.umb.cs681.hw16;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeCart implements Cart {
    private int items = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addItem() {
        lock.writeLock().lock();
        try {
            items++;
            System.out.println("Item added : : total items in cart " + items);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void removeItem() {
        lock.writeLock().lock();
        try {

            items--;
            System.out.println("Item removed from cart : total items in cart " + items);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getItems() {
        lock.readLock().lock();
        try {
            return items;
        } finally {
            lock.readLock().unlock();
        }
    }
}
