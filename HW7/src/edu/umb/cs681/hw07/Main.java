package edu.umb.cs681.hw07;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        
        LocalDateTime date = LocalDateTime.now();

        Directory dr1 = new Directory(null, "Root", 0, date);
        Directory dr2 = new Directory(dr1, "Home", 0, date);
        Directory dr3 = new Directory(dr2, "SubDir", 0, date);

        File f1 = new File(dr2, "Main.java", 5, date);

        Link link1 = new Link(dr2, "Test.link", 3, date, f1);
        Link link2 = new Link(dr3, "Test2.link", 4, date, dr3);


        FileSystem instance  = FileSystem.getInstance();
        instance.apendRootDir(dr1);
        instance.apendRootDir(dr2);

        RunnableFileSystem gen1 = new RunnableFileSystem();
        RunnableFileSystem gen2 = new RunnableFileSystem();
        RunnableFileSystem gen3 = new RunnableFileSystem();
        Thread t1 = new Thread(gen1);
        Thread t2 = new Thread(gen2);
        Thread t3 = new Thread(gen3);
        t1.start();
        t2.start();
        t3.start();
    }
}