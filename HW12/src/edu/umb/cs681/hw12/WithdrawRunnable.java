package edu.umb.cs681.hw12;


public class WithdrawRunnable implements Runnable {
    private BankAccount account;
    private volatile boolean done = false;

    public WithdrawRunnable(BankAccount account) {
        this.account = account;
    }

    public void setDone() {
       done = true;
    }

    public void run() {

        for (int i = 0; i < 10; i++) {

            if (done) {
                System.out.println("Withdraw runnable terminated");
                break;
            }
            account.withdraw(100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
                continue;
            }

        }

    }
}