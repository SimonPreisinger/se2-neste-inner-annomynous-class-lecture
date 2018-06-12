import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Worker extends Thread {
    private int result;

    @Override
    public void run() {
        System.out.println("run called");
        System.out.println("working .. ");

        try {
            Thread.sleep((int)Math.random() * 5000);
        } catch (InterruptedException e) {
            throw new AssertionError(e);        }
        result = (int)(Math.random() * 1000);
        System.out.println("run returns");
    }

    public int getResut() {
        return result;
    }

}


public class Concurrency {

    public static void main(String... args) {
        List<Worker> workers = Stream.generate(Worker::new)
                .peek(worker -> worker.setDaemon(true))
                .limit(100)
                .collect(Collectors.toList());
        workers.forEach(Worker::start);
           /* workers.stream().forEach(worker -> {
            try {
                worker.join();
            } catch (InterruptedException e) {
                System.exit(0);
            }
        });
        */
        workers.stream().map(Worker::getResut).forEach(System.out::println);


        Worker worker = new Worker();
        System.out.println("main calling start");
        worker.start();
        Worker coWorker = new Worker();
        coWorker.start();
//        worker.start(); // start nur einmal erlaubt
//        worker.run(); // sequenzial
        System.out.println("start returned");
        try {
//            Thread.sleep(3000);
            System.out.printf("worker is alive %bin" , worker.isAlive());
            worker.join(); //wartet bis prozess fertig
            coWorker.join();

            System.out.printf("join returned %bin" , worker.isAlive());
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
        System.out.println("worker computet "+ worker.getResut());
        System.out.println("coworker computet "+ worker.getResut());
        System.out.println("main ends");


    }
}
