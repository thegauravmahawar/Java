public class ConstructorExecution {

    public static void main(String... args) {

        /**
         *
         * In a class hierarchy, constructors complete their execution in order of derivation, from superclass to
         * subclass. Further, since super() must be the first statement executed in a subclass' constructor, this order
         * is the same whether super() is used. If super() is not used, then the default or parameterless
         * constructor of each superclass will be executed.
         *
         */
        C c = new C();
        /**
         *
         * Outputs:
         *
         * Inside A's constructor.
         * Inside B's constructor.
         * Inside C's constructor.
         *
         */
    }

    static class A {
        A() {
            System.out.println("Inside A's constructor.");
        }
    }

    static class B extends A {
        B() {
            System.out.println("Inside B's constructor.");
        }
    }

    static class C extends B {
        C() {
            System.out.println("Inside C's constructor.");
        }
    }
}
