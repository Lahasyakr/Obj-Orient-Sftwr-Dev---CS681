package edu.umb.cs681.hw16;


public class NotThreadSafeCart implements Cart {
    private int items = 0;

    public void addItem() {
        items++;
        System.out.println("Item added to cart : total items in cart " + items);
    }

    public void removeItem() {
        items--;
        System.out.println("Item removed from cart : total items in cart " + items);
    }

    public int getItems() {
        return items;
    }

}