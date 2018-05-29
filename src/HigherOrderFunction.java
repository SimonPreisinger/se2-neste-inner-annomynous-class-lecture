import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class HigherOrderFunction {

    public static void main(String... args) {
        /***
         * Argument
         */
        Consumer<Runnable> twice = runnable -> {
            runnable.run();
            runnable.run();
        };

        twice.accept(() -> System.out.print("hans" + "\n") );

        /***
         * Ergebnis
         *
         */
        Function<String, Consumer<String>> prettyPrinter;
        prettyPrinter = (String deco) -> x -> System.out.println(deco + x+ deco);
        Consumer<String> sss = prettyPrinter.apply("baby");
        sss.accept("naja");

        /***
         * Argument und Ergebnis
         */

        UnaryOperator<Comparator<String>> reverser =
                comp -> (i0, i1) -> comp.compare(i1, i0);

        String s0 = "lalala";
        String s1 = "ba";

        Comparator<String> shortestFirst = Comparator.comparingInt(String::length);
        System.out.println(shortestFirst.compare(s0,s1));
        System.out.println(reverser.apply(shortestFirst).compare("sdfdf", "sdfsdf"));

    }
}
