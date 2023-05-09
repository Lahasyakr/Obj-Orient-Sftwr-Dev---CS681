package edu.umb.cs681.hw12;

public class Main {
    public static void main(String[] args) throws Exception {

        ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
        WithdrawRunnable withdrawRunnable1 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable1 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable2 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable2 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable3 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable3 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable4 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable4 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable5 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable5 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable6 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable6 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable7 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable7 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable8 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable8 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable9 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable9 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable10 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable10 = new DepositRunnable(account);
        WithdrawRunnable withdrawRunnable11 = new WithdrawRunnable(account);
        DepositRunnable depositRunnable11 = new DepositRunnable(account);

        Thread withdraw_t1 = new Thread(withdrawRunnable1);
        Thread deposit_t1 = new Thread(depositRunnable1);
        Thread withdraw_t2 = new Thread(withdrawRunnable2);
        Thread deposit_t2 = new Thread(depositRunnable2);
        Thread withdraw_t3 = new Thread(withdrawRunnable3);
        Thread deposit_t3 = new Thread(depositRunnable3);
        Thread withdraw_t4 = new Thread(withdrawRunnable4);
        Thread deposit_t4 = new Thread(depositRunnable4);
        Thread withdraw_t5 = new Thread(withdrawRunnable5);
        Thread deposit_t5 = new Thread(depositRunnable5);
        Thread withdraw_t6 = new Thread(withdrawRunnable6);
        Thread deposit_t6 = new Thread(depositRunnable6);
        Thread withdraw_t7 = new Thread(withdrawRunnable7);
        Thread deposit_t7 = new Thread(depositRunnable7);
        Thread withdraw_t8 = new Thread(withdrawRunnable8);
        Thread deposit_t8 = new Thread(depositRunnable8);
        Thread withdraw_t9 = new Thread(withdrawRunnable9);
        Thread deposit_t9 = new Thread(depositRunnable9);
        Thread withdraw_t10 = new Thread(withdrawRunnable10);
        Thread deposit_t10 = new Thread(depositRunnable10);
        Thread withdraw_t11 = new Thread(withdrawRunnable11);
        Thread deposit_t11 = new Thread(depositRunnable11);

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
        withdraw_t11.start();
        deposit_t11.start();

        withdrawRunnable1.setDone();
        depositRunnable1.setDone();
        withdrawRunnable2.setDone();
        depositRunnable2.setDone();
        withdrawRunnable3.setDone();
        depositRunnable3.setDone();
        withdrawRunnable4.setDone();
        depositRunnable4.setDone();
        withdrawRunnable5.setDone();
        depositRunnable5.setDone();
        withdrawRunnable6.setDone();
        depositRunnable6.setDone();
        withdrawRunnable7.setDone();
        depositRunnable7.setDone();
        withdrawRunnable8.setDone();
        depositRunnable8.setDone();
        withdrawRunnable9.setDone();
        depositRunnable9.setDone();
        withdrawRunnable10.setDone();
        depositRunnable10.setDone();
        withdrawRunnable11.setDone();
        depositRunnable11.setDone();

        
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

    }
}
