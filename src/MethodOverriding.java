public class MethodOverriding {

    public static void main(String... args) {

        /**
         *
         * In a class hierarchy, when a method in a subclass has the same name and type signature as a method in its
         * superclass, then the method in the subclass is said to override the method in the superclass. When an overridden
         * method is called from within its subclass, it will always refer to the version of that method defined by the
         * subclass. The version of the method defined by the superclass will be hidden.
         *
         */
        B b = new B();
        b.name(); //outputs B

        /**
         *
         * Method overriding forms the basis for dynamic method dispatch.
         * Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time,
         * rather than compile time. Dynamic method dispatch is important because this is how Java implements run-time
         * polymorphism.
         *
         * A superclass reference variable can refer to a subclass object. Java uses this fact to resolve calls to
         * overridden methods at run time. When an overridden method is called through a superclass reference, Java
         * determines which version fo that method to execute based upon the type of the object being referred to at
         * the time the call occurs.
         *
         *
         */
        A a = new A();
        D d = new D();
        E e = new E();

        A r; // obtain reference of type A

        r = a; //r refers to an A object
        r.name(); //outputs A

        r = d; //r refers to an D object
        r.name(); //outputs D

        r = e; //r refers to an E object
        r.name(); //outputs E

        /**
         *
         * As the output in the above code shows, the version of name() executed is determined by the type of object
         * being referred to at the time of the call. Had it been determined by the type of the reference variable, r,
         * we would see three calls to A's name() method.
         *
         */

        /**
         *
         * Polymorphism: The dictionary definition refers polymorphism to a principle in biology in which an organism or
         * species can have many forms or stages. In object-oriented programming, subclasses of a class can
         * define their own unique behaviors and yet share some of the same functionality of the parent class.
         *
         * Overridden methods allow Java to support run-time polymorphism. Polymorphism allows a general class to specify
         * methods that will be common to all of its derivatives, while allowing subclasses to define the specific
         * implementation of some or all of those methods.
         *
         */
    }

    static class A {
        void name() { System.out.println("A"); }
    }

    static class B extends A {
        void name() { System.out.println("B"); }
    }

    static class C extends B {
        void name() { System.out.println("C"); }
    }

    static class D extends A {
        void name() { System.out.println("D"); }
    }

    static class E extends A {
        void name() { System.out.println("E"); }
    }
}
