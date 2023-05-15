package edu.umb.cs681.hw08;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer
        extends RunnableCancellablePrimeFactorizer {

    private final ReentrantLock lock = new ReentrantLock();

    public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void generatePrimeFactors() {

        long divisor = from;
        while (dividend != 1 && divisor <= to) {

            lock.lock();
            try {
                if (isDone()) {
                    System.out.println("Factors generation process is stopped !!");
                    this.factors.clear();
                    break;
                }
                if (divisor > 2 && isEven(divisor)) {
                    divisor++;
                    continue;
                }
                if (dividend % divisor == 0) {
                    factors.add(divisor);
                    dividend /= divisor;
                } else if (divisor == 2) {
                    divisor++;
                } else {
                    divisor += 2;
                }
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

    public static void main(String[] args) {
        /*-------------single thread------------------- */
        RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(36,
                2, 30);

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
