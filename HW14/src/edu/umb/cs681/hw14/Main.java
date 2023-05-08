package edu.umb.cs681.hw14;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        AdmissionMonitor monitor = new AdmissionMonitor();
        EntranceHandler entryThread = new EntranceHandler(monitor);
        ExitHandler exitThread = new ExitHandler(monitor);
        StatsHandler statsThread = new StatsHandler(monitor);

        Thread t1 = new Thread(entryThread);
        Thread t2 = new Thread(exitThread);
        Thread t3 = new Thread(statsThread);
        Thread t4 = new Thread(entryThread);
        Thread t5 = new Thread(exitThread);
        Thread t6 = new Thread(statsThread);

        t1.start();
        t4.start();
        t2.start();
        t3.start();
       
        t5.start();
        t6.start(); 

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        exitThread.setDone();
        statsThread.setDone();
        entryThread.setDone();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt(); 
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
