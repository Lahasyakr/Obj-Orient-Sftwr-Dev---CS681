Shooping Cart Application with Thread-Safe and Not Thread-Safe Implementations.

This app simulates a basic Shopping cart management system, where customers can add and remove items from a cart.

The app includes two different implementations of the Cart interface:
- NotThreadSafeCart: an implementation that is not thread-safe, and can result in race conditions and incorrect behavior when multiple threads access 
  the same cart object simultaneously.
- ThreadSafeCart: an implementation that uses a ReentrantLock to ensure thread-safety when multiple threads access the same cart object.

Why the original code is not thread-safe:
    The original implementation of the Cart interface (NotThreadSafeCart) is not thread-safe because it allows multiple threads to access and modify the 
    cart items concurrently, without any synchronization or locking mechanisms. This can result in race conditions, where multiple threads modify the 
    same data at the same time, which can lead to inconsistent data and incorrect behavior.

How the code was revised to be thread-safe:
    To make the Cart implementation thread-safe, the "ThreadSafeCart" class was created to use a ReentrantLock to ensure that only one thread can access the 
    cart items variable at a time. The ReentrantLock is acquired at the beginning of each method that modifies the cart items, and is released at the end of the method. 
    This ensures that only one thread can modify the cart items at a time, preventing race conditions and ensuring thread-safety.

To demonstrate the difference between the thread-safe and not thread-safe versions of the Cart implementation, a Main class is provided that creates 
three instances of each implementation and simulates three customer threads adding and removing items from each cart object. 
The every step of each cart object is printed to the console, showing the difference in behavior between the two implementations.
