# Design Patterns

## Singleton

**Singleton** is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

Singleton pattern solves two problems

- Ensures that a class has just a single instance
- Provide a global access point to that instance

Implementation

- Make the default constructor private, to prevent other objects from using the `new` operator with a Singleton class
- Create a static creation method that acts as a constructor

**Naive Singleton (Single Threaded)**

```java
public final class Singleton {
    private static Singleton instance;
    public String value;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

**Thread-safe Singleton**

```java
public final class Singleton {
    
    //The field must be declared volatile so that double check lock would work correctly
    private static volatile Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        //The approach taken here is called double-checked locking (DCL)
        //It exists to prevent race condition between multiple threads that may attempt to get singleton instance at the same time.
        //
        //It may seem that having `result` variable here is completely pointless. 
        //There is, however, a very important caveat when implementing double-checked locking in Java, which is solved by introducing a local variable.
        //
        //Obtaining and releasing a lock by synchronization is an expensive operation.
        //Here, it is checked if the instance is initialized or not (without obtaining the lock). If it is initialized, return it immediately.
        //Obtain the lock
        //Double-check whether the variable has already been initialized: if another thread acquired the lock first, it may have already done the initialization. If so, return the initialized variable
        //Otherwise initialize the variable and return
        Singleton result = instance;
        if (result != null) return result;
        
        synchronized (Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
}
```