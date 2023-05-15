package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);

        children = new LinkedList<>();

        if (parent != null) {
            parent.appendChild(this);
        }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public LinkedList<FSElement> getChildren() {
        lock.lock();
        try {
            return this.children;
        } finally {
            lock.unlock();
        }
    }

    public void appendChild(FSElement file) {
        lock.lock();
        try {
            children.add(file);
        } finally {
            lock.unlock();
        }
    }

    public int countChildren() {
        int countOfChildren = 0;
        lock.lock();
        try {
            for (FSElement item : children) {
                countOfChildren += 1;
            }
            return countOfChildren;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<Directory> getSubDirectories() {
       
        lock.lock();
        try {
            LinkedList<Directory> directoriesList = new LinkedList<>();
            for (FSElement item : children) {
                if (item.isDirectory())
                    directoriesList.add((Directory) item);
            }
            return directoriesList;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<File> getFiles() {
       
        lock.lock();
        try {
            LinkedList<File> files = new LinkedList<>();
            for (FSElement item : children) {
                if (!item.isDirectory())
                    files.add((File) item);
            }
            return files;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<Link> getLinks() {
       
        lock.lock();
        try {
            LinkedList<Link> links = new LinkedList<>();
            for (FSElement fsEle : children) {
                if (fsEle instanceof Link) {
                    links.add((Link) fsEle);
                }
            }
            return links;
        } finally {
            lock.unlock();
        }
    }

    public int getTotalSize() {
       
        lock.lock();
        try {
            int totalSize = 0;
            LinkedList<FSElement> childrenList = getChildren();
            for (FSElement child : childrenList) {
                if (child.isDirectory())
                    totalSize += ((Directory) child).getTotalSize();
                else
                    totalSize += child.getSize();
            }
            return totalSize;
        } finally {
            lock.unlock();
        }
    }

}