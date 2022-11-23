public class AbstractClasses {

    public static void main(String... args) {

        /**
         *
         * We sometimes will want to create superclass that only defines a generalized form that will be shared by all
         * of its subclasses, leaving it to each subclass to fill in the details. Such a class determines the nature of the
         * methods that the subclasses must implement.
         *
         * Any class that contains one or more abstract methods must also be declared abstract. There can be no objects
         * of an abstract class. That is, an abstract class cannot be directly instantiated with the new operator.
         * Such objects would be useless, because an abstract class is not fully defined. Also, we cannot declare abstract
         * constructors, or abstract static methods. Any subclass of an abstract class must either implement all the
         * abstract methods in the superclass, or be declared abstract itself.
         *
         */
        B b = new B();
        b.name();
        b.print("Hello World!");

        /**
         *
         * In the above code, no object of class A are declared. It is not possible to instantiate an abstract class.
         *
         * Although abstract classes cannot be used to instantiate objects, they can be used to create object references,
         * because Java's approach to run-time polymorphism is implemented through the use of superclass references. Thus,
         * it must be possible to create a reference to an abstract class so that it can be used to point to a subclass
         * object.
         *
         */
    }

    static abstract class A {

        abstract void name();
        void print(String message) { System.out.println(message); }
    }

    static class B extends A {
        void name() { System.out.println("B"); }
    }
}
