package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
    private ConcurrentHashMap<Path, AtomicInteger> ACMap = new ConcurrentHashMap<Path, AtomicInteger>();

    private static AccessCounter instance = null;
    private static ReentrantLock lock = new ReentrantLock();

    private AccessCounter() {
    }

    public static AccessCounter getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                synchronized (AccessCounter.class) {
                    instance = new AccessCounter();
                }
            }
            return instance;
        } finally {
            lock.unlock();
        }

    }

    public void increment(Path path) {
        ACMap.putIfAbsent(path, new AtomicInteger(0));
        ACMap.get(path).incrementAndGet();
    }

    public AtomicInteger getCount(Path path) {
        return ACMap.get(path);
    }
}
