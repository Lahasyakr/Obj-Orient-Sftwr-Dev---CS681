package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private volatile boolean done = false;
    private AdmissionMonitor monitor;

    public ExitHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
    }

    public void setDone() {
        done = true;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) { // for infinite loop
            lock.lock();
            try {
                if (done) {
                    System.out.println("As done = true Exit Denied!");
                    break;
                }
                monitor.exit();
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
