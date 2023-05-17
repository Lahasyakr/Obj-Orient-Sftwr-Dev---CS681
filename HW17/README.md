This application simulates a cafeteria scenario where two threads are trying to make coffee using a coffee machine and a water dispenser. 
The goal is to ensure thread safety while accessing these shared resources.

It consists of two classes: NotSafeCafeteria and SafeCafeteria.


The app includes two different implementations of the cafeteria interface:
- NotSafeCafeteria: An implementation that is not thread-safe, and can result in potential deadlock as two threads uses multiple locks (coffeeLock and waterLock) in an 
    inconsistent order.
- SafeCafeteria: An implementation, where locks (coffeeLock and waterLock) are acquired in a consistent order in all threads to eliminate the possibility of deadlock.

### Why the original code is not thread-safe:
   The original code in the NotSafeCafeteria class is not thread-safe because it uses multiple locks (coffeeLock and waterLock) in an 
    inconsistent order in the different threads. This inconsistency can lead to a potential deadlock, where both 
    threads hold one lock and are waiting to acquire the other lock, resulting in a state where no progress can be made.

### How the code was revised to be thread-safe:
   To make the code thread-safe, the SafeCafeteria class was introduced. In this revised code, the locks (coffeeLock and waterLock) are acquired in a 
    consistent order in both threads, preventing potential deadlocks. The order of acquiring locks ensures that if one thread has acquired the coffeeLock, 
    the other thread must wait until it is released before attempting to acquire it. This approach eliminates the possibility of a deadlock.


To demonstrate the difference between the thread-safe and not thread-safe versions of the Cafeteria implementation, Main class is implemented.
It creates instances of both SafeCafeteria and NotSafeCafeteria classes and calls the demo method on each. 
The SafeCafeteria demonstrates the thread-safe implementation, while the NotSafeCafeteria demonstrates the potential deadlock scenario.

It is important to note that the NotSafeCafeteria portion of the application may result in a deadlock, and if detected, 
it terminates the threads by interrupting one of them and on the safer side to terminate program execution for the purpose of successful build I have used System.exit(0) to Terminate the program .
