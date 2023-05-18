package edu.umb.cs681.hw16;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeLibrary implements Library {
    private int books = 0;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addBook() {
        lock.writeLock().lock();
        try {
            books++;
            System.out.println("Book returned : : total books in Library : " + books);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void removeBook() {
        lock.writeLock().lock();
        try {

            books--;
            System.out.println("Book borrowed from Library : total books in Library : " + books);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getBooks() {
        lock.readLock().lock();
        try {
            return books;
        } finally {
            lock.readLock().unlock();
        }
    }
}
