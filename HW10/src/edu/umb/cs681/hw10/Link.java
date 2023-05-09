package edu.umb.cs681.hw10;

import java.time.LocalDateTime;

public class Link extends FSElement {

    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        parent.appendChild(this);
        this.target = target;
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