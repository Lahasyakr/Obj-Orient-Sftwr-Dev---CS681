package edu.umb.cs681.primes;

public class Main {
    public static void main(String args[]) {
        //****************prime generation ***********************/
        RunnableCancellablePrimeGenerator gen1 = new RunnableCancellablePrimeGenerator(1, 100);
        Thread t1 = new Thread(gen1);
        t1.start();
        // gen1.setDone();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final result usimg single thread: ");
        gen1.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));

        // two threads
        System.out.println("\n using multiple threads");
        RunnableCancellablePrimeGenerator gen2 = new RunnableCancellablePrimeGenerator(1, 100);
        RunnableCancellablePrimeGenerator gen3 = new RunnableCancellablePrimeGenerator(101, 200);
        Thread t2 = new Thread(gen2);
        Thread t3 = new Thread(gen3);

        t2.start();
        t3.start();
        // gen2.setDone();
        gen3.setDone();

        try {
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
        }

        gen2.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
        gen3.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));

        long primeNum = gen2.getPrimes().size() + gen3.getPrimes().size();
        System.out.println("\n" + primeNum + " prime numbers are found in total.");

        // ****************Prime factorization**************/

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

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

        /* r1.setDone();
        r2.setDone(); */

        try {
            thread1.join();
            thread2.join();
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
