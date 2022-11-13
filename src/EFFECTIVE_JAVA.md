# Effective Java

## Creating and Destroying Objects

### Consider static factory methods instead of constructors

A class can provide a public *static factory method*, which is simply a static method that returns an instance of the class.

```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;    
}
```

#### Advantages

**Static factory methods, unlike constructors, have names.**

> If the parameters to a constructor do not, in and of themselves, describe the object being returned, a static factory with a well-chosen name is easier to use and the resulting client code easier to read.
> 
> For example the constructor, `BigInteger(int, int, Random)`, which returns a `BigInteger` that is probably prime, would have been better expressed as a static factory method named `BigInteger.probablePrime`. 

**Static factory methods, unlike constructors, are not required to create a new object each time they're invoked.**

> This allows immutable classes to use preconstructed instances, or to cache instances as they're constructed, and dispense them repeatedly to avoid creating duplicate objects. 

**Static factory methods, unlike constructors, can return an object of any subtype of their return type.**

> One application of this flexibility is that an API can return objects without making their classes public. Hiding implementation classes in this fashion leads to a very compact API.

**Static factory methods reduce the verbosity of creating parameterized type instances.**

> We must specify the type parameters when we invoke the constructor of a parameterized class even if they're obvious from context.
> 
> ```java
> Map<String, List<String>> m = new HashMap<String, List<String>>();
> ```
> 
> With static factories, however, the compiler can figure out the type parameters for you.
> 
> ```java
> public static <K, V> HashMap<K, V> newInstance() {
>     return new HashMap<K, V>();
> }
> ```
> 
> Then we could replace the wordy declaration above with this succinct alternative:
> 
> ```java
> Map<String, List<String>> m = HashMap.newInstance();
> ```

#### Disadvantages

**Classes with only static factory methods without public or protected constructors cannot be subclassed.**
**Static factory methods are not readily distinguishable from other static methods.**

## Consider a builder when faced with many constructor parameters

## Enforce the singleton property with a private constructor or an enum type

## Enforce noninstantiability with a private constructor

## Avoid creating unnecessary objects

## Eliminate obsolete object references

## Avoid finalizers