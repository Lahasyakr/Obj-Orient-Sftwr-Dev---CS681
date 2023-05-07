package edu.umb.cs681.hw07;

public class RunnableFileSystem implements Runnable {

    @Override
    public void run() {
        var instance  = FileSystem.getInstance();
        System.out.println("Instance of FileSysytem class :"+ instance);
        System.out.println("\n Root Directory :"+ instance.getRootDirs());
        
    }
    
}
