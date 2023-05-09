
package edu.umb.cs681.hw09;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        SampleRunnable gen1 = new SampleRunnable();
        SampleRunnable gen2 = new SampleRunnable();
        SampleRunnable gen3 = new SampleRunnable();
        SampleRunnable gen4 = new SampleRunnable();
        Thread T1 = new Thread(gen1);
        Thread T2 = new Thread(gen2);
        Thread T3 = new Thread(gen3);
        Thread T4 = new Thread(gen4);

        T1.start();
        T2.start();
        T3.start();
        T4.start();
    }
}
