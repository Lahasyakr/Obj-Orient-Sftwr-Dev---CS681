package edu.umb.cs681.hw18;

public class Main {
    public static void main(String[] args) {

        RequestHandler gen1 = new RequestHandler();

        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen1);
        Thread t3 = new Thread(gen1);
        Thread t4 = new Thread(gen1);
        Thread t5 = new Thread(gen1);
        Thread t6 = new Thread(gen1);
        Thread t7 = new Thread(gen1);
        Thread t8 = new Thread(gen1);
        Thread t9 = new Thread(gen1);
        Thread t10 = new Thread(gen1);
        Thread t11 = new Thread(gen1);
        Thread t12 = new Thread(gen1);
        Thread t13 = new Thread(gen1);
        Thread t14 = new Thread(gen1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gen1.setDone();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt();
        t7.interrupt();
        t8.interrupt();
        t9.interrupt();
        t10.interrupt();
        t11.interrupt();
        t12.interrupt();
        t13.interrupt();
        t14.interrupt();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
