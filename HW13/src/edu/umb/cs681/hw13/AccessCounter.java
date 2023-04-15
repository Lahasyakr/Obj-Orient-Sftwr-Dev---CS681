package edu.umb.cs681.hw13;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class AccessCounter {
    private HashMap<java.nio.file.Path, Integer> ACMap = new HashMap<>();
    private static final ReentrantLock staticLock = new ReentrantLock();
    private final ReentrantReadWriteLock nonStaticLock = new ReentrantReadWriteLock();

    private static AccessCounter instance = null;

    private AccessCounter() {
    }

    public static AccessCounter getInstance() {
        staticLock.lock();
        try {
            if (instance == null)
                instance = new AccessCounter();
            return instance;
        } finally {
            staticLock.unlock();
        }
    }

    public void increment(Path path) {
        nonStaticLock.writeLock().lock();
        try {
            if (ACMap.get(path) != null)
                ACMap.put(path, ACMap.get(path) + 1);
            else
                ACMap.put(path, 1);
        } finally {
            nonStaticLock.writeLock().unlock();
        }
    }

    public int getCount(Path path) {
        nonStaticLock.readLock().lock();
        try {
            if (ACMap.get(path) != null)
                return ACMap.get(path);
            else
                return 0;
        } finally {
            nonStaticLock.readLock().unlock();
        }
    }
}
