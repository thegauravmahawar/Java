import java.io.BufferedWriter;
import java.io.FileWriter;

import static java.lang.Math.abs;

public class Java17 {

    //Switch Labelled Rule.
    private static void switch1(int value) {
        String answer = switch (abs(value)) {
            case 0 -> "Zero";
            case 1, 2, 3, 4, 5 -> "Five or less";
            default -> "Not sure, but more than six.";
        };
        System.out.println(answer);
    }

    //Switch Labelled Statement Group.
    private static void switch2(int value) {
        String answer = switch (abs(value)) {
            case 0:
                System.out.println("Value is zero.");
                yield "Zero";
            case 1, 2, 3, 4, 5:
                System.out.println("Value is between 1 and 5.");
                yield "Five or less.";
            default:
                System.out.println("Another value.");
                yield "Not sure, but more than six.";
        };
        System.out.println(answer);
    }

    //Text Blocks
    private static void textBlock() throws Exception {
        var writer = new BufferedWriter(new FileWriter("demo.txt"));
        writer.write("""
               <html>
                 <body>
                   <p>
                     <div>Hello World!</div>
                   </p>
                 </body>
               </html>
               """);
        writer.close();
    }

    //Note: The variables are effectively final, meaning that after
    //the constructor has completed their values cannot be changed anymore.
    //The Java compiler will automatically generate the constructor, getter
    //for the instance variables, hashcode, equals, and toString methods.
    public record PersonRecord(String name, int age) {}

    public static void main(String... args) throws Exception {
        switch1(0);
        switch2(3);
        textBlock();

        var person1 = new PersonRecord("John", 17);
        System.out.println(person1);
    }
}