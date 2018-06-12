import java.awt.*;
import java.nio.file.OpenOption;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String... args) {
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
        Stream<String> iterateStream = Stream.iterate("start", function);
        Stream.iterate(1, n -> n + 1);

        Predicate<String> predicate = (x) -> (x.length() < 3) ? true : false;
        Stream<String> filterd = collectionStream.filter(predicate);
        System.out.println(filterd.toArray().toString());

        Stream<String> same = algoStream.peek((x) -> System.out.println(x));

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer i = 0; i < 100; i++) {
            arrayList.add(i);
            arrayList.add(i - i);
        }
        Double[] integers = arrayList.stream().limit(10)
                .map((x) -> (double) x)
                .flatMap(n -> Stream.of(n + n + n))
                //.distinct()
                .filter((x) -> x < 10 ? true : false)
                .sorted()

                .toArray(Double[]::new);

        for (Double inti : integers)
            System.out.println(inti);

        Optional<Integer> optionalInteger = Stream.iterate(0, n -> n + 1)
                .limit(50)
                .filter(x -> x>50 ? true:false)
                .findAny();
                //.findFirst();

        if(optionalInteger.isPresent())
            System.out.println(optionalInteger + "is present");
        else
            System.out.println("is not present");

        Optional<Double> opti = Stream.generate(Math::random)
                .limit(30)
                .peek((x)-> System.out.println(x))
            .filter((x) -> x > 0.5)
                    .findAny();
        if (opti.isPresent()) {
            System.out.println("yo");
        } else {
            System.out.println("no");
        }

//        Integer[] integers1 = (Integer[]) Stream.iterate(0, n -> n + 1)
//                .limit(100)
//                .toArray();

        List<Integer> numbers = Stream.iterate(1 , n -> n + 1)
                .limit(10)
                .peek((x)-> System.out.println(x))
                .collect(Collectors.toList());
        numbers.forEach((x)-> System.out.printf(String.valueOf(x)));
        Set<Integer> set = Stream.iterate(1, n -> n + 1)
                .limit(50)
                .collect(Collectors.toSet());
        set.forEach((x)-> System.out.println(x));

        Optional<Integer> daint =  Stream.iterate(0, n -> n +1)
                .limit(50)
                .peek(x -> System.out.println(x))
                .filter((x)-> x > 50)
                .peek(x -> System.out.println(x))
                .findAny();

//        if(daint.isPresent())
//            System.out.printf("isch present");
//        else
//            System.out.println("ne isch a it");

        boolean treffer = Stream.iterate(1, n -> n + 1)
               // .limit(1000)
                .anyMatch((x)-> x == 0);
        System.out.println(treffer);






    }

}
