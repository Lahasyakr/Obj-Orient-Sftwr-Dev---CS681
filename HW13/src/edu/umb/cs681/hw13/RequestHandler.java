package edu.umb.cs681.hw13;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

public class RequestHandler implements Runnable {

    volatile boolean done = false;

    public void setDone() {
        done = true;
    }

    @Override
    public void run() {
        String[] files = {
                "a.html",
                "b.html",
                "c.html",
                "d.html",
                "e.html" };

        AccessCounter ac = AccessCounter.getInstance();

        while (true) { // for infinite loop

            if (done) {
                System.out.println(Thread.currentThread().getName() + " done == true Exit !!!");
                break;
            }

            int ranNum = new Random().nextInt(files.length);
            Path path = FileSystems.getDefault().getPath(".", files[ranNum]); // random file path

            ac.increment(path);
            System.out.println(files[ranNum] + " \t: " + ac.getCount(path));

            try {
                System.out.println("going to sleep for a while.. " + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("wake up!. " + Thread.currentThread().getName());
                System.out.println(e.toString());
                continue;
            }
        }
    }

    public static void main(String[] args) {

        RequestHandler gen1 = new RequestHandler();
        RequestHandler gen2 = new RequestHandler();
        RequestHandler gen3 = new RequestHandler();
        RequestHandler gen4 = new RequestHandler();
        RequestHandler gen5 = new RequestHandler();
        RequestHandler gen6 = new RequestHandler();
        RequestHandler gen7 = new RequestHandler();
        RequestHandler gen8 = new RequestHandler();
        RequestHandler gen9 = new RequestHandler();
        RequestHandler gen10 = new RequestHandler();
        RequestHandler gen11 = new RequestHandler();
        RequestHandler gen12 = new RequestHandler();
        RequestHandler gen13 = new RequestHandler();
        RequestHandler gen14 = new RequestHandler();

        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);
        Thread t3 = new Thread(gen3);
        Thread t4 = new Thread(gen4);
        Thread t5 = new Thread(gen5);
        Thread t6 = new Thread(gen6);
        Thread t7 = new Thread(gen7);
        Thread t8 = new Thread(gen8);
        Thread t9 = new Thread(gen9);
        Thread t10 = new Thread(gen10);
        Thread t11 = new Thread(gen11);
        Thread t12 = new Thread(gen12);
        Thread t13 = new Thread(gen13);
        Thread t14 = new Thread(gen14);

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
        gen2.setDone();
        gen3.setDone();
        gen4.setDone();
        gen5.setDone();
        gen6.setDone();
        gen7.setDone();
        gen8.setDone();
        gen9.setDone();
        gen10.setDone();
        gen11.setDone();
        gen12.setDone();
        gen13.setDone();
        gen14.setDone();

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
    }

}
