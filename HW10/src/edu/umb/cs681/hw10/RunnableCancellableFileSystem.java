package edu.umb.cs681.hw10;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableFileSystem implements Runnable {
    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellableFileSystem() {

    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {

        while (true) {
            lock.lock();
            try {
                if (done) {
                    System.out.println(Thread.currentThread().getName()+ " - " + "Acess Terminated");
                    break;
                } else {
                    LocalDateTime date = LocalDateTime.now();
                    FileSystem fs = FileSystem.getInstance();
                    Directory root = new Directory(null, "root", 0, date);
                    Directory Apps = new Directory(root, "Apps", 0, date);
                    Directory bin = new Directory(root, "bin", 0, date);
                    Directory home = new Directory(root, "home", 0, date);
                    Directory pictures = new Directory(home, "pictures", 0, date);
                    File x = new File(Apps, "x", 1, date);
                    File y = new File(bin, "y", 2, date);
                    File a = new File(pictures, "a", 4, date);
                    File b = new File(pictures, "b", 5, date);
                    File c = new File(home, "c", 6, date);
                    Link d = new Link(root, "d", 1, date, pictures);
                    Link e = new Link(root, "e", 2, date, x);
                    System.out.println(Thread.currentThread().getName()+ " - " + "is Root directory: " + root.isDirectory());
                    System.out.println(Thread.currentThread().getName()+ " - " + "is e directory: " + e.isDirectory());
                    System.out.println(Thread.currentThread().getName()+ " - " + "is e Link: " + e.isLink());
                    System.out.println(Thread.currentThread().getName()+ " - " + "is x directory: " + x.isDirectory());
                    System.out.println(Thread.currentThread().getName()+ " - " + "target of link d : " + d.getTarget().getName());
                    System.out.println(Thread.currentThread().getName()+ " - " + "parent of link d : " + d.getParent().getName());

                    System.out.println(Thread.currentThread().getName()+ " - " + "target of link e : " + e.getTarget().getName());
                    System.out.println(Thread.currentThread().getName()+ " - " + "parent of link e : " + e.getParent().getName());

                    System.out.println(Thread.currentThread().getName()+ " - " + "count of sub directories under root  :  " + root.getSubDirectories().size());

                    System.out.println(Thread.currentThread().getName()+ " - " + "Subdirctories of Root : \t\t");
                    root.getSubDirectories().forEach((item) -> System.out.print(item.getName() + ", "));
                    System.out.println();

                }
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }

        }
    }
}
