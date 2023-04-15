package edu.umb.cs681.hw10;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class FileSystem {
    private static FileSystem instance = null;
    LinkedList<Directory> rootDirs = new LinkedList<>();
    private static ReentrantLock lock = new ReentrantLock();

    private FileSystem() {
    }

    public static FileSystem getInstance() {
        lock.lock();
        try {
            if (instance == null)
                instance = new FileSystem();
            return instance;
        } finally {
            lock.unlock();
        }

    }

    public LinkedList<Directory> getRootDirs() {
        lock.lock();
        try {
            return this.rootDirs;
        } finally {
            lock.unlock();
        }
    }

    public void apendRootDir(Directory root) {
        lock.lock();
        try {
            rootDirs.add(root);
        } finally {
            lock.unlock();
        }
    }

}