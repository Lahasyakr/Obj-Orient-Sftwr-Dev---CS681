This apllication simulates Library with Thread-Safe and Not Thread-Safe Implementations.

This app simulates a basic library management system, where students can borrow and return books from a Library.

The app includes two different implementations of the Library interface:
- NotThreadSafeLibrary: an implementation that is not thread-safe, and can result in race conditions and incorrect behavior when multiple threads access 
  the same Library object simultaneously.
- ThreadSafeLibrary: an implementation that uses a ReentrantReadWriteLock to ensure thread-safety when multiple threads access the same Library object.

### Why the original code is not thread-safe:
   The original implementation of the Library interface (NotThreadSafeLibrary) is not thread-safe because it allows multiple threads to access and modify the 
    Library "books" concurrently, without any synchronization or locking mechanisms. This can result in race conditions, where multiple threads modify the 
    same data at the same time, which can lead to inconsistent data and incorrect behavior.

### How the code was revised to be thread-safe:
   To make the Library implementation thread-safe, the "ThreadSafeLibrary" class was created to use a ReentrantReadWriteLock.
    The ReentrantReadWriteLock provides a way to allow multiple threads to read the shared resource i.e library's "books" variable simultaneously 
    while ensuring that only one thread can modify the library books at a time.
    The addBook() and removeBook() methods use the writeLock() method to acquire a write lock, which ensures that only one thread can modify the 
    books variable at a time. The getBooks() method uses the readLock() method to acquire a read lock, which allows multiple threads to read the 
    books variable simultaneously without interfering with each other., preventing race conditions and ensuring thread-safety.


To demonstrate the difference between the thread-safe and not thread-safe versions of the Library implementation, a Main class is provided that creates 
three instances of each implementation and simulates three student threads returning and borrowing books from each Library object. 
The every step of each Library object is printed to the console, showing the difference in behavior between the two implementations.
