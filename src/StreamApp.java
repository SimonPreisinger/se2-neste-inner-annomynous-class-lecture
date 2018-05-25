import java.util.ArrayList;
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
         */
        al.stream()
                .filter(string -> string.indexOf('a') >= 0)
                .map(String::length) // anderer Typ
                .map(string -> string + "'") // gleicher Typ
                .forEach(System.out::println); // Terminale Operation
    }
}
