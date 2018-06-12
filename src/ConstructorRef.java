import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorRef {



    public static void main(String... args){

        Consumer<Runnable> hundertmal;

        hundertmal = r -> {
            List<Integer> integers = Stream.iterate(0, n -> n + 1)
                    .limit(100)
                    .collect(Collectors.toList());
            for (Integer integer:integers)
                r.run();
        };
        hundertmal.accept(()-> System.out.println(23));


    }

        //Wertzuweisung
}
