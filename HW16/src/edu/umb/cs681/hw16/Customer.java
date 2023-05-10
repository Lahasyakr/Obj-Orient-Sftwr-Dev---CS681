package edu.umb.cs681.hw16;

public class Customer implements Runnable {
    private Cart cart;

    public Customer(Cart cart) {
        this.cart = cart;
    }

    public void run() {
       for (int i = 0; i < 5; i++) {
            cart.addItem();
        }

        cart.removeItem();
    }

}