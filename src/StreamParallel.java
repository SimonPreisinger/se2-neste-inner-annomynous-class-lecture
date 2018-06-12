import java.util.concurrent.ForkJoinPool.*;

import java.util.stream.Stream;


public class StreamParallel {
    static long startTime = System.currentTimeMillis();

    public static void main(String... args) {

        Stream.iterate(0, n -> n + 1)
                .sequential()
                .limit(100)
                .peek((x) -> System.out.println(x))
                .forEach(StreamParallel::workHard);

    }


    static void workHard(Integer integer) {
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
