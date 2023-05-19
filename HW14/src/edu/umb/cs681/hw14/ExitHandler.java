package edu.umb.cs681.hw14;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;
    private AdmissionMonitor monitor;

    public ExitHandler(AdmissionMonitor monitor) {
        this.monitor = monitor;
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
        // TODO Auto-generated method stub
        while (true) { // for infinite loop
            lock.lock();
            try {
                if (done) {
                    System.out.println(Thread.currentThread().getName()+ " : " + "As done = true Exit!! Exit thread");
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
