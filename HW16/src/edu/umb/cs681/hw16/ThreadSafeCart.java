package edu.umb.cs681.hw16;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCart implements Cart {
    private int items = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void addItem() {
        lock.lock();
        try {
            items++;
            System.out.println("Item added : : total items in cart " + items);
        } finally {
            lock.unlock();
        }
    }

    public void removeItem() {
        lock.lock();
        try {

            items--;
            System.out.println("Item removed from cart : total items in cart " + items);
        } finally {
            lock.unlock();
        }
    }

    public int getItems() {
        lock.lock();
        try {
            return items;
        } finally {
            lock.unlock();
        }
    }
}
