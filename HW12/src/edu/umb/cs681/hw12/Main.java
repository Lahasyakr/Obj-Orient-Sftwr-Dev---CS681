package edu.umb.cs681.hw12;

public class Main {
    public static void main(String[] args) throws Exception {

        ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
        WithdrawRunnable withdrawRunnable = new WithdrawRunnable(account);
        DepositRunnable depositRunnable = new DepositRunnable(account);

        Thread withdraw_t1 = new Thread(withdrawRunnable);
        Thread deposit_t1 = new Thread(depositRunnable);
        Thread withdraw_t2 = new Thread(withdrawRunnable);
        Thread deposit_t2 = new Thread(depositRunnable);
        Thread withdraw_t3 = new Thread(withdrawRunnable);
        Thread deposit_t3 = new Thread(depositRunnable);
        Thread withdraw_t4 = new Thread(withdrawRunnable);
        Thread deposit_t4 = new Thread(depositRunnable);
        Thread withdraw_t5 = new Thread(withdrawRunnable);
        Thread deposit_t5 = new Thread(depositRunnable);
        Thread withdraw_t6 = new Thread(withdrawRunnable);
        Thread deposit_t6 = new Thread(depositRunnable);
        Thread withdraw_t7 = new Thread(withdrawRunnable);
        Thread deposit_t7 = new Thread(depositRunnable);
        Thread withdraw_t8 = new Thread(withdrawRunnable);
        Thread deposit_t8 = new Thread(depositRunnable);
        Thread withdraw_t9 = new Thread(withdrawRunnable);
        Thread deposit_t9 = new Thread(depositRunnable);
        Thread withdraw_t10 = new Thread(withdrawRunnable);
        Thread deposit_t10 = new Thread(depositRunnable);

        withdraw_t1.start();
        deposit_t1.start();
        withdraw_t2.start();
        deposit_t2.start();
        withdraw_t3.start();
        deposit_t3.start();
        withdraw_t4.start();
        deposit_t4.start();
        withdraw_t5.start();
        deposit_t5.start();
        withdraw_t6.start();
        deposit_t6.start();
        withdraw_t7.start();
        deposit_t7.start();
        withdraw_t8.start();
        deposit_t8.start();
        withdraw_t9.start();
        deposit_t9.start();
        withdraw_t10.start();
        deposit_t10.start();

        withdrawRunnable.setDone();
        depositRunnable.setDone();

        withdraw_t1.interrupt();
        deposit_t1.interrupt();
        withdraw_t2.interrupt();
        deposit_t2.interrupt();
        withdraw_t3.interrupt();
        deposit_t3.interrupt();
        withdraw_t4.interrupt();
        deposit_t4.interrupt();
        withdraw_t5.interrupt();
        deposit_t5.interrupt();
        withdraw_t6.interrupt();
        deposit_t6.interrupt();
        withdraw_t7.interrupt();
        deposit_t7.interrupt();
        withdraw_t8.interrupt();
        deposit_t8.interrupt();
        withdraw_t9.interrupt();
        deposit_t9.interrupt();
        withdraw_t10.interrupt();
        deposit_t10.interrupt();

        try {
            withdraw_t1.join();
            deposit_t1.join();
            withdraw_t2.join();
            deposit_t2.join();
            withdraw_t3.join();
            deposit_t3.join();
            withdraw_t4.join();
            deposit_t4.join();
            withdraw_t5.join();
            deposit_t5.join();
            withdraw_t6.join();
            deposit_t6.join();
            withdraw_t7.join();
            deposit_t7.join();
            withdraw_t8.join();
            deposit_t8.join();
            withdraw_t9.join();
            deposit_t9.join();
            withdraw_t10.join();
            deposit_t10.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
