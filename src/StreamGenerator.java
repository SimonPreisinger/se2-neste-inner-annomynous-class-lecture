import java.util.Optional;
import java.util.stream.Stream;

public class StreamGenerator {

    public static void main(String... args) {
        Stream.of(1,2,3,4)
                .flatMap(number -> Stream.of(number-1, number + 1))
                .forEach(System.out::println);
    }
}
