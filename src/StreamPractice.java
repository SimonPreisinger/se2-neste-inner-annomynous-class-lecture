import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String... args){
        ArrayList<String> list = new ArrayList<>();
        list.add("abra");
        list.add("ka");
        list.add("dabra");
        Stream<String> collectionStream = list.stream();


        String[] array = new String[]{};
        Stream<String> arrayStream = Stream.of(array);

        /***
         * einzeln
         */
        Stream<String> ownStream = Stream.of("a", "b", "c");

        /***
         * Algorithmus
         */
        Supplier<String> stringSupplier = () -> "sdf";
        Stream<String> algoStream = Stream.generate(stringSupplier);

        UnaryOperator<String> function = (x) -> (x + "#");
        Stream<String> iterateStream = Stream.iterate("start",function);
        Stream.iterate(1, n -> n + 1);

        Predicate<String> predicate = (x) -> (x.length() < 3)?true:false;
        Stream<String> filterd = collectionStream.filter(predicate);
        System.out.println(filterd.toArray().toString());

        Stream<String> same = algoStream.peek((x)-> System.out.println(x));

    }

}
