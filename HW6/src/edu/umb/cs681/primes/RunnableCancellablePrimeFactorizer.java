package edu.umb.cs681.primes;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {

    private boolean done = false;
    private ReentrantLock lock = new ReentrantLock();

    public RunnableCancellablePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
        // TODO Auto-generated constructor stub
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimeFactors() {

        long divisor = from;
        while (dividend != 1 && divisor <= to) {

            lock.lock();
            try {
                if (done) {
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
        }
    }

    public static void main(String[] args) {

        //***************Single Thread**************

        System.out.println("\n\nPrime Factorization of 36	using single thread:\n");
        RunnableCancellablePrimeFactorizer gen = new RunnableCancellablePrimeFactorizer(36, 2, (long) Math.sqrt(36));

        Thread thread = new Thread(gen);

        thread.start();
        gen.setDone();

        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.print("Factors are	:");
        gen.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));

        // ***************Multi - Thread************

        System.out.println("\n\nPrime Factorization of 2489 using multi thread	:\n");

        RunnableCancellablePrimeFactorizer r1 = new RunnableCancellablePrimeFactorizer(2489, 2,
                (long) Math.sqrt(2489) / 2);
        RunnableCancellablePrimeFactorizer r2 = new RunnableCancellablePrimeFactorizer(2489,
                1 + (long) Math.sqrt(2489) / 2, (long) Math.sqrt(2489));

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        r1.setDone();
        r2.setDone();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (r1.getPrimeFactors().isEmpty()) {
            Long temp = 2489 / r2.getPrimeFactors().element();
            System.out.println(
                    "Here, one set is empty, the complete set of prime factors will be derived from the other");
            System.out.print("Factors are	:");
            r2.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
            System.out.print(temp);
        } else if (r2.getPrimeFactors().isEmpty()) {
            Long temp = 2489 / r1.getPrimeFactors().element();
            System.out.println(
                    "Here, one set is empty, the complete set of prime factors will be derived from the other");
            System.out.print("Factors are	:");
            r1.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
            System.out.print(temp);
        } else {
            System.out.print("Factors are	:");
            r1.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
            r2.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
        }
    }
}
