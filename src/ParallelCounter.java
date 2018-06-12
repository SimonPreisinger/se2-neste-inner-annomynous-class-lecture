public class ParallelCounter {
    static int count = 0;
    static final Object monitor = new Object();

    static class Incrementer extends Thread {
        @Override
        public void run() {
            // synchronized hier falsch, threads laufen nacheinander
               // synchronized (monitor) {
            for (int i = 0; i < 10_000_000; i++) {
                synchronized (monitor) { //synchronized ist teuer (Zeit)
                    // ohne synchronized Falsches Ergebnis möglich
                    count++;

                }
            }
        }
    }

    public static void main(String... args) throws InterruptedException {
        Thread thread1 = new Incrementer();
        Thread thread2 = new Incrementer();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count); //count = count +1 von verschiedenen Threads

    }
}
