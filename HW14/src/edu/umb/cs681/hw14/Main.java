package edu.umb.cs681.hw14;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        AdmissionMonitor monitor = new AdmissionMonitor();
        EntranceHandler entryThread = new EntranceHandler(monitor);
        ExitHandler exitThread = new ExitHandler(monitor);
        StatsHandler statsThread = new StatsHandler(monitor);
        EntranceHandler entryThread2 = new EntranceHandler(monitor);
        ExitHandler exitThread2 = new ExitHandler(monitor);
        StatsHandler statsThread2 = new StatsHandler(monitor);

        Thread t1 = new Thread(entryThread);
        Thread t2 = new Thread(exitThread);
        Thread t3 = new Thread(statsThread);
        Thread t4 = new Thread(entryThread2);
        Thread t5 = new Thread(exitThread2);
        Thread t6 = new Thread(statsThread2);

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
        exitThread2.setDone();
        statsThread2.setDone();
        entryThread2.setDone();

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();
        t5.interrupt();
        t6.interrupt(); 
        
    }
}
