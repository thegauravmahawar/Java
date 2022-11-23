## Basics

**Definition**

A class that is derived from another class is called a subclass (also a derived class, extended class, or child class).
The class from which the subclass is derived is called a superclass (also a base class or a parent class).

**The idea of inheritance**

When we want to create a new class and there is already a class that includes some of the code that we want, we can
derive our new class from the existing class. In doing this, we can reuse the fields and methods of the existing class
without having to write (and debug) them ourselves.

## An Example

**A Bicycle class**

```java
public class Bicycle {

    public int cadence;
    public int gear;
    public int speed;

    public Bicycle(int cadence, int gear, int speed) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
    }    

    public void setCadence(int cadence) {
        this.cadence = cadence;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

}
```

**A MountainBike class**

```java
public class MountainBike extends Bicycle {

    public int seatHeight;

    public MountainBike(int seatHeight, int cadence, int gear, int speed) {
        this.seatHeight = seatHeight;
        super(cadence, gear, speed);
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

}
```

`MountainBike` inherits all the fields and methods of `Bicycle` and adds the field `seatHeight` and a method to set it.
Except for the constructor, it is as if we had written a new `MountainBike` class entirely from scratch, with four fields
and five methods.

## What we can do in Subclasses

A subclass inherits all of the *public* and *protected* methods of its parent, no matter what package the subclass is in.
If the subclass is in the same package as its parent, it also inherits the *package-private* members of the parent.

- The inherited fields can be used directly.
- We can declare a fields in the subclass with the same name as the one in the superclass, thus *hiding* it (not recommended).
- We can declare new fields in the subclass.
- The inherited methods can be used directly as they are.
- We can write a new *instance* method in the subclass that has the same signature as the one in the superclass, thus
  *overriding* it.
- We can write a new *static* method in the subclass that has the same signature as the one in the superclass, thus
  *hiding* it.
- We can declare new methods in the subclass that are not in the superclass.

## Private members in a Superclass

A subclass does not inherit the *private* members of its parent class. However, if the superclass has public or protected
methods for accessing its private fields, these can also be used by the subclass.

A nested class has access to all the private members of its enclosing class - both fields and methods.

## Casting Objects

```text
MountainBike bike = new MountainBie();
```

In the above code, `bike` is of type `MountainBike`.

`MountainBike` is descended from `Bicycle` and `Object`. Therefore, a `MountainBike` is a `Bicycle` and is also an `Object`,
and it can be used wherever `Bicycle` or `Object` objects are called for.

The reverse is not necessarily true: a `Bicycle` may be a `MountainBike`, but it isn't necessarily

```text
Object obj = new MountainBike();
```

In the above code, obj is both an `Object` and a `MountainBike`. This is called *implicit* casting.

On the other hand,

```text
MountainBike bike = obj;
```

we would get a compile-time error because obj is not known to the compiler to be a `MountainBike`. However, we can tell
the compiler that we promise to assign a `MountainBike` to obj by *explicit* casting.

```text
MountainBike bike = (MountainBike) obj;
```        

This cast inserts a runtime check that obj is assigned a `MountainBike` so that the compiler can safely assume that obj
is a `MountainBike`. If obj is not a `MountainBike` at runtime, an exception will be thrown.


**A logical test to save us from the runtime error**

```text
if (obj instanceof MountainBike) {
    MountainBike bike = (MountainBike) obj;
}
```

## Topics

- [Constructor Execution](ConstructorExecution.java)
- [Method Overriding](MethodOverriding.java)
- [Abstract Classes](AbstractClasses.java)
