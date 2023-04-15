package edu.umb.cs681.hw11;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private HashMap<java.nio.file.Path, Integer> ACMap = new HashMap<>();
    private static final ReentrantLock staticLock = new ReentrantLock();
    private final ReentrantLock nonStaticLock = new ReentrantLock();

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
        nonStaticLock.lock();
        try {
            if (ACMap.get(path) != null)
                ACMap.put(path, ACMap.get(path) + 1);
            else
                ACMap.put(path, 1);
        } finally {
            nonStaticLock.unlock();
        }
    }

    public int getCount(Path path) {
        nonStaticLock.lock();
        try {
            if (ACMap.get(path) != null)
                return ACMap.get(path);
            else
                return 0;
        } finally {
            nonStaticLock.unlock();
        }
    }
}
