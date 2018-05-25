import java.util.function.*;

public class HDF { // Higher Order Functions
    public static void main(String... args) {
        Consumer<Runnable> twice;
        twice = r -> { // Typ findet Compiler allein
            r.run();
            r.run();
        };


        twice.accept(() -> System.out.println(42));

        // return (Integer x) -> {return x > min && x < max;};}; // Orginal
        BiFunction<Integer, Integer, Predicate<Integer>> inrange = (min, max) -> x -> x > min && x < max; // verkürzt
        Predicate<Integer> isValidPercent = inrange.apply(0, 100);
        System.out.println(isValidPercent.test(50));
        System.out.println(isValidPercent.test(-3));
        Predicate<Integer> isValidMont = inrange.apply(0, 12);
        System.out.println(isValidMont.test(3));
        System.out.println(isValidMont.test(13));

        BinaryOperator<UnaryOperator<Integer>> compose = (f, g) -> x -> g.apply(f.apply(x));
        UnaryOperator<Integer> pls = compose.apply(
                compose.apply(x -> x + 1, x -> x * x),
                              x -> x - 1);

        System.out.println(pls.apply(5));

    }
}
