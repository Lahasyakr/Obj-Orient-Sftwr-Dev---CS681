package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class Link extends FSElement {

    private FSElement target;
    private static ReentrantLock lock = new ReentrantLock();

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        parent.appendChild(this);
        lock.lock();
        try {
            this.target = target;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public boolean isLink() {
        return true;
    }

    public FSElement getTarget() {
        lock.lock();
        try {
            return target;
        } finally {
            lock.unlock();
        }
    }
}