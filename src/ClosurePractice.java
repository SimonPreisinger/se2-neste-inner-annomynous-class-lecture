import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ClosurePractice {
    public static void main(String... args) throws Exception {
        Runnable r;
        {
            int i = 1;

            r = () -> System.out.println(i);
        }
        {
            int i = 2;
            r.run();

        }

        UnaryOperator<Double> sin = Math::sin;
            Double jo = sin.apply(23.2323);
        System.out.println(jo);

        Function<Integer, String> sub =  "hello"::substring;
        String result = sub.apply(2);
        System.out.println(result);
        BiFunction<String, Integer, String> sub2 = String::substring;
        String result2 = sub2.apply("hansi", 3);
        System.out.println(result2);

        Callable<Double> callable = Math::random;
        System.out.println(callable.call());
        UnaryOperator<Double> consumer = Math::sqrt;
        Double dou = Double.valueOf(2323);
        Double sdf = consumer.apply(Double.valueOf(23));
        System.out.println(sdf);
        System.out.println(Math.random());

        Function<Integer, String> f1;
        BiFunction<Integer, Integer, String> f2;
        f1 = "helloeoe"::substring;
        f2 = "sdfsdfjsdf"::substring;

        System.out.println(f1.apply(2));
        System.out.println(f2.apply(2,4));





    }
}
