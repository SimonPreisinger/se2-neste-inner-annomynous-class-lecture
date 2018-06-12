import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class HDFPractice {
    public static void main(String... args){
    Function<Character, Consumer<String>> prettyPrinter;
        prettyPrinter =
                (character) -> completString ->
                        System.out.println(character + completString + character);
        prettyPrinter.apply('*').accept("Hello");
        prettyPrinter.apply('+').accept("ssdfs");

        UnaryOperator<Comparator<String>> reverse;
        reverse = comparer-> (i0, i1) -> comparer.compare(i1,i0);

        String fst = "2323";
        String snd = "565656";
        Comparator<String> shortestFirst = (i0, i1)-> i0.length()-i1.length();
        Comparator<String> longestFirst = (i0, i1) -> i1.length() - i0.length();
        System.out.println(reverse.apply(shortestFirst).compare(fst,snd));
        System.out.println(reverse.apply(longestFirst).compare(fst,snd));




    }


}
