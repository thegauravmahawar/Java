# Creating and Destroying Objects

## Consider static factory methods instead of constructors

A class can provide a public *static factory method*, which is simply a static method that returns an instance of the class.

```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;    
}
```

**Advantages**

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

**Disadvantages**

**Classes with only static factory methods without public or protected constructors cannot be subclassed.**

**Static factory methods are not readily distinguishable from other static methods.**

## Consider a builder when faced with many constructor parameters

Static factories and constructors share a limitation: they do not scale well to large numbers of optional parameters.

> Example: Consider a class representing the Nutrition Facts label that appears on packaged foods. These labels have a few required fields - serving size, servings per container, and calories per serving - and over twenty option fields - total fat, saturated fat, trans fat, and so on. Most products have nonzero values for only a few of these optional fields.

**Builder Pattern**

```java
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public static class Builder {
        
        //Required parameters
        private final int servingSize;
        private final int servings;
        
        //Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;
        
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        
        public Builder calories(int val) { 
            calories = val;
            return this;
        }
        
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }
        
        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }
    
    public NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
```

Note that `NutritionFacts` is immutable, and that all parameter default values are in a single location.

```java
NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
        .calories(100)
        .sodium(35)
        .carbohydrate(27)
        .build();
```

## Enforce the singleton property with a private constructor or an enum type

## Enforce noninstantiability with a private constructor

## Avoid creating unnecessary objects

## Eliminate obsolete object references

## Avoid finalizers