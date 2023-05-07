package edu.umb.cs681.hw07;

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
        return this.children;
    }

    public void appendChild(FSElement file) {
        children.add(file);
    }

    public int countChildren() {
        int countOfChildren = 0;
        for (FSElement item : children) {
            countOfChildren += 1;
        }
        return countOfChildren;
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> directoriesList = new LinkedList<>();
        for (FSElement item : children) {
            if (item.isDirectory())
                directoriesList.add((Directory) item);
        }
        return directoriesList;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        for (FSElement item : children) {
            if (!item.isDirectory())
                files.add((File) item);
        }
        return files;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> links = new LinkedList<>();
        for (FSElement fsEle : children) {
            if (fsEle instanceof Link) {
                links.add((Link) fsEle);
            }
        }
        return links;
    }


    public int getTotalSize() {
        int totalSize = 0;
        LinkedList<FSElement> childrenList = getChildren();
        for (FSElement child : childrenList) {
            if (child.isDirectory())
                totalSize += ((Directory) child).getTotalSize();
            else
                totalSize += child.getSize();
        }
        return totalSize;
    }

}