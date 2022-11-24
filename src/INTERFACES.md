## Interfaces

## Basics

Objects define their interactions with the outside world through methods that they expose. Methods form the object's
*interface* with the outside world; the buttons on the front of our television set, for example, are the interface between
us and the electrical wiring on the other side of its plastic casing. We press the "power" button to turn the television
on and off.

There are a number of situations in software engineering when it is important for disparate groups of programmers to agree
to a "contract" that spells out how their software interacts. Each group should be able to write their code without any
knowledge of the other groups' code is written. Generally speaking, *interfaces* are such contracts.

For example, imagine a futuristic society where computer-controlled robotic cars transport passengers through city streets
without a human operator. Automobile manufacturers write code that operates the automobile - stop, start, accelerate, and
so forth. Another industrial group, electronic guidance instrument manufacturers, make computer systems that receive GPS
position data and wireless transmission traffic conditions use that information to drive the car.

The auto manufacturers must publish an industry standard interface that spells out in detail what methods can be invoked
to make the car move (any car, from any manufacturer). The guidance manufacturers can then write software that invokes
the methods described in the interface to command the car. Neither industrial group needs to know how the other group's
software is implemented. In fact, each group considers its software highly proprietary and reserves the right to modify
it at any time, as long as it continues to adhere to the published interface.

In its most common form, an interface is a group of related methods with empty bodies.

## An Interface Example

```java
interface Bicycle {

    //wheel revolutions per minute
    void changeCadence(int cadence);

    void changeGear(int gear);

    void speedUp(int increment);

    void applyBrake(int decrement);

}
```

Implementation of the interface `Bicycle`:

```java
class MountainBike implements Bicycle {

    int cadence = 0;
    int gear = 1;
    int speed = 0;

    /**
     *
     * The compiler will now require that methods changeCadence, changeGear, speedUp, applyBrake 
     * all be implemented. Compilation will fail if those methods are missing from  this class.
     *
     */
    
    public void changeCadence(int cadence) {
        this.cadence = cadence;
    }

    public void changeGear(int gear) {
        this.gear = gear;
    }

    public void speedUp(int increment) {
        speed += increment;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

}
```

Implementing an interface allows a class to become more formal about the behavior it promises to provide. Interfaces form
a contract between the class and the outside world, and this contract is enforced at build time by the compiler. If our
class claims to implement an interface, all methods defined by that interface must appear in its source code before the
class will successfully compile.

## Interfaces vs. Abstract Classes

Abstract classes are similar to interfaces. We cannot instantiate them, and they may contain a mix of methods declared
with or without an implementation. However, with abstract classes, we can declare fields that are not static and final, and
define concrete methods. With interfaces, all fields are automatically public, static, and final, and all methods that we
declare or define are public. In addition, we can extend only one class, whether or not it is abstract, whereas we can
implement any number of interfaces.

We can consider abstract classes when:

- We want to share code among several closely related classes.
- We expect that classes that extend our abstract class have many common methods or fields, or require access modifiers
  other than public.
- We want to declare non-static and non-final fields. This enables us to define methods that can access and modify the
  state of the object to which they belong.

We can consider interfaces when:

- We expect that unrelated classes would implement our interface. For example, the interfaces `Comparable` and `Cloneable`
  are implemented by many unrelated classes.
- We want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
- We want to take advantage of multiple inheritance of type.

An example of an abstract class in the `JDK` is `AbstractMap`, which is part of the Collections Framework. Its subclasses
(which include `HashMap`, `TreeMap`, and `ConcurrentHashMap`) share many methods (including `get`, `put`, `isEmpty`, `containsKey`
and `containsValue`) that `AbstractMap` defines.

An example of a class in the `JDK` that implements several interfaces is `HashMap`, which implements the interfaces `Serializable`,
`Cloneable`, and `Map<K, V>`.

If we only want to declare which methods and members a class must have, then we should use Interfaces. A class can implement
multiple Interfaces.

If we also want to have a default implementation, then we can use an Abstract class. Abstract classes can contain fields
that are not static and final, and they can contain implemented methods. Such abstract classes are similar to interfaces,
except that they provide partial implementation, leaving it to the subclasses to complete the implementation. If an abstract
class contains only abstract method declarations, it should be declared as an interface instead. A class can extend only
one Abstract class.

## An Abstract Class Example

In an object-oriented drawing application, we can draw circles, rectangles, lines, Bezier curves, and many other graphic
objects. These objects all have certain states (for example: position, orientation, line color, fill color) and
behaviors (for example: moveTo, rotate, resize, draw) in common. Some of these states and behaviors are the same for all
graphic objects (for example: position, fill color, and moveTo). Others require different implementations (for example: resize or draw).
All `GraphicObjects` must be able to draw or resize themselves; they just differ in how they do it. This is a perfect situation
for an abstract superclass. We can take advantage of the similarities and declare all the graphic objects to inherit from the
same abstract parent object.

```java
abstract class GraphicObject {

    int x, y;

    void moveTo(int x, int y) {
        //implementation
    }

    abstract void draw();

    abstract void resize();

}
```

Each non-abstract subclass of `GraphicObject`, such as `Circle` and `Rectangle`, must provide implementations for the `draw`
and `resize` methods.

```java
class Circle extends GraphicObject {

    void draw() {
        //implementation
    }

    void resize() {
        //implementation
    }

}
```

## When an Abstract Class implements an Interface

It is possible, to define a class that does not implement all the interface's methods, provided that the class is declared
to be `abstract`.

For example,

```java
abstract class X implements Y {
    //implements all but one method of Y
}

class XX extends X {
    //implements the remaining method of Y
}
```

In this case, class `X` must be `abstract` because it does not fully implement `Y`, but class `XX` does, in fact, implement `Y`.