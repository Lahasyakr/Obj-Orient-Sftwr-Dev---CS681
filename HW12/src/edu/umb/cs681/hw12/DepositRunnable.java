package edu.umb.cs681.hw12;


public class DepositRunnable implements Runnable {
    private BankAccount account;
    private volatile boolean done = false;

    public DepositRunnable(BankAccount account) {
        this.account = account;
    }

    public void setDone() {
       done = true;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {
            if (done) {
                    System.out.println(Thread.currentThread().getName() + " - " + "Deposit runnable terminated");
                break;
            }
            account.deposit(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }

        }

    }
}
