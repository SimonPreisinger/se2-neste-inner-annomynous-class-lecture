import org.omg.CORBA.INTERNAL;

import java.lang.reflect.Array;
import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.*;

public class ClosureLambda {
    static int foo(String s, String t){
        return s.length() - t.length();
    }
    public static final Comparator<String> SHORTEST_FIRST = ClosureLambda::foo;


    private static int checkOrBomb(int number, Supplier<Exception> bombMaker) throws Exception {
        if(number%2!=0)
            throw bombMaker.get();
        return number;
    }

    // get Property vonAussen Definiert
    private static Consumer<String> tracer = System.getProperty("tracing") == null ? s -> {}
    : System.out::println;
    // private static Consumer<String> tracer = s -> {};
    // private static Consumer<String> tracer = System.out::println;
    static void processArray(double[] array, UnaryOperator<Double> operator){
        for(int index=0; index < array.length; index++){
            array[index] = operator.apply(array[index]);
        }
    }
    public static void main(String... args) throws Exception{
        //System.out.println(SHORTEST_FIRST...);

        int even = checkOrBomb(4, IllegalArgumentException::new); //schnell Weil Exeption nur bei Fehler erzeugt
        even = checkOrBomb(22, Exception::new);
        /***
         * frei Methodenrefernez
         */

        UnaryOperator<String> stringOp = String::trim;
        System.out.println(stringOp.apply("hello\t\n\n"));


        BiFunction<String, Integer, String> stringOpSub = String::substring;
        System.out.println(stringOpSub.apply("Abra ka dabra", 5));
        /***
         * gebunden Methodenrefernz
         */
        tracer.accept("main called");
        Supplier<Integer> s = "hello"::length; // Code weiß auf welches Objekt er sich bezieht z.B. "hello"
        // ...
        System.out.println(s.get());

        Consumer<String> stringEater = System.out::println;
        //...
        stringEater.accept("Abra ka dabra");

        tracer.accept("main exit");

        /***
         * statisch Methodenreferenz
         */

        double[] numbers = {1,2,3,42,238, -9};
        processArray(numbers, Math::sin);
        processArray(numbers, n -> Math.sin(n)); // n -> Math.sin(n) == Math::sin
        // processArray(numbers, n -> n + 1);
        System.out.println(Arrays.toString(numbers));

        //Consumer<String[]> arrayEater = ClosureLambda::main;
        // arrayEater.accept(args); // Stackoverflow

        BiConsumer<double[], UnaryOperator<Double>> arrayModder = ClosureLambda::processArray;
        arrayModder.accept(numbers, n -> n / 2);
        System.out.println(Arrays.toString(numbers));
        /***
         * 1.Code
         */
        UnaryOperator<Integer> twice = x -> x + x;
        UnaryOperator<Double> twiceAgain = x -> x + x;
        UnaryOperator<String> concat = x -> x + x;
        // Object x = x -> x + x;

        // Lambda Ausdruck ist Polytype, erst bei Zuweisung wird typ entschieden
        System.out.println(twice.apply(4));
        System.out.println(twiceAgain.apply(4d)); // Landa Ausdruck allein weiß nichts vom Typ
        System.out.println(concat.apply("4"));

       // Runnable r = () -> System.out.println(toString()); // es gibt kein Objekt, toString() geht nicht weil kein this
       // r.run();
       // r = new Runnable() { // es gibt ein Object (this)
       //     @Override
       //     public void run() {
       //         System.out.println(toString());
       //     }
       // };
       // r.run();
    }
}
