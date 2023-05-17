package edu.umb.cs681.hw17;

public class Main {
    public static void main(String[] args) {

        SafeCafeteria safecafe1 = new SafeCafeteria();
        safecafe1.demo(args);

        NotSafeCafeteria cafe1 = new NotSafeCafeteria();
        cafe1.demo(args);

    }
}
