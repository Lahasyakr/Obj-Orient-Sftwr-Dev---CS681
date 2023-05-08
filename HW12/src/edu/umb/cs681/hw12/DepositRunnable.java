package edu.umb.cs681.hw12;

import java.time.Duration;
import java.util.concurrent.locks.ReentrantLock;

public class DepositRunnable implements Runnable {
    private BankAccount account;
    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;

    public DepositRunnable(BankAccount account) {
        this.account = account;
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    if (done) {
                        System.out.println("Deposit runnable terminated");
                        break;
                    }
                    account.deposit(100);
                    Thread.sleep(Duration.ofSeconds(2).getSeconds());
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
        } catch (InterruptedException exception) {
        }
    }
}
