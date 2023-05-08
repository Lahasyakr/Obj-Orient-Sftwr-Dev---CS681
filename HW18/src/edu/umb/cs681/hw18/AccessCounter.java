package edu.umb.cs681.hw18;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;

public class AccessCounter {
    private ConcurrentHashMap<Path, Integer> ACMap = new ConcurrentHashMap<>();

    private static AccessCounter instance = null;

    private AccessCounter() {
    }

    public static AccessCounter getInstance() {
        if (instance == null)
            instance = new AccessCounter();
        return instance;
    }

    public void increment(Path path) {
        ACMap.compute(path, (k, v) -> {
            return v == null ? 1 : v + 1;
        });
    }

    public int getCount(Path path) {
        return ACMap.getOrDefault(path, 0);
    }
}
