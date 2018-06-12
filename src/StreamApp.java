import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String... args){
        //Stream<String> ints = Stream.of(args);
        //Stream<Integer> ints = Stream.of(1,2,3,4,5);
        //System.out.println(ints.count());
        //System.out.println(ints.count());

        ArrayList<String> al = new ArrayList<String>() {
            {
                add("foo");
                add("bar");
                add("bazzz");
            }
        };
        //Stream<String> ints = al.stream(); // Generator
        /***
         * langform
        Stream<String> ints = al.stream(); // Generator
        ints = ints.filter(string -> string.indexOf('a') >= 0); // Intermediate Operation
        // ints.forEach((String s) -> {System.out.println(s);}); //Orginal
        ints.forEach(System.out::println); // Terminale Operation
         */
        /***
         * kurzform
         *
         */
        boolean found = Stream.iterate(0, r -> r +1)
                .anyMatch(r -> r == 37);
        System.out.println(found);

        Optional<Integer> optionalInteger = Stream.iterate(1, n -> n + 1)
                .parallel()
                .limit(100)
                .filter(n -> n%37 == -10)
                //.findAny();
                .findFirst(); // stream wird sequentiell
        if(optionalInteger.isPresent())
            System.out.println(optionalInteger.get());
        else
            System.out.println("nix gefunden");
        System.out.println(optionalInteger.isPresent());


        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .anyMatch(r -> r == 37);
                //.flatMap(n -> Stream.of(n - 1,n, n + 1))
                //.flatMap(n -> Stream.iterate(n, f -> f +2).limit(5))
                //.sequential()
                //.parallel()
                //.forEach(System.out::println);
        Stream.of("a", "b", "c", "d", "e", "f", "g", "h") //logische Reihenfolge
        //Stream.iterate("+", string->string + "+") //generiert Daten auf Abruf
        //al.stream() //fluent Interface: Kette von Funktionen wird aufgerufen
                .skip(2) //überspringt 2 Elemente logisches überspringen, nicht zeitlich
                .peek(string -> System.out.println("-->" + string))
                .limit(5) //schneidet unendlichen stream ab
                .filter(string -> string.indexOf('a') >= 0)
                .peek(string -> System.out.println("-->" + string))
                .map(String::length) // anderer Typ
                .map(string -> string + "'") // gleicher Typ
                .distinct() //jede Zahl nur einmal
                .sorted()
                .forEach(System.out::println); // Terminale Operation

        Stream<String> stringStream = Stream.iterate("+", string -> string + "+")
                .limit(5);
        stringStream.forEach(System.out::println);


        Stream.Builder<Double> builder = Stream.builder();
        for(int i = 0; i < 10;i++){
            builder.add(Math.random());
        }
        builder.build()
                .map(n -> n * 6)
                .distinct()
                .forEach(System.out::println);

        Stream<Double> doubles = Stream.generate(Math::random);
        doubles.map(n -> n*6)
                .map(n -> n + 1)
                .map(n -> (int)(double)n)
                .distinct() // jede Zahl nur einmal
                .limit(10)
                .forEach(System.out::println);

    }
}
