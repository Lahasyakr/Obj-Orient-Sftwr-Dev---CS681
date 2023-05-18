package edu.umb.cs681.hw08;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        /*-------------single thread------------------- */
        RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(144,
        2, 12);

        Thread t = new Thread(gen);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gen.setDone();
        t.interrupt();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\n" + gen.getPrimeFactors() + " are the prime factors.");
        System.out.print("Factors of 36 are	:\t\t");
        gen.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));


         /*-------------mutli thread------------------- */

        RunnableCancellableInterruptiblePrimeFactorizer gen1 = new RunnableCancellableInterruptiblePrimeFactorizer(84,
                2, 9);
        RunnableCancellableInterruptiblePrimeFactorizer gen2 = new RunnableCancellableInterruptiblePrimeFactorizer(36,
                2, 30);

        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);

        t1.start();
        t2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gen1.setDone();
        gen2.setDone();
        t1.interrupt();
        t2.interrupt();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("Factors of 84 are	:\t\t");
        gen1.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
        System.out.println();

        System.out.print("Factors of 36 are	:\t\t");
        gen2.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
    }
}
