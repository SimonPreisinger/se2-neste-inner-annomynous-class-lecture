public class UsingInterrupts {
    static class ThreadWorker extends Thread {
        private int counter;

        public int getCounter() {
            return counter;
        }

        @Override
        public void run() {
            while (!interrupted())
                counter++;
        }
    }
    public static void main(String... args) throws InterruptedException {
        ThreadWorker threadWorker = new ThreadWorker();
        threadWorker.start();
        Thread.sleep(1_000);
        System.out.println(threadWorker.isAlive());
        threadWorker.interrupt();
//        Thread.yield();
        Thread.sleep(1);
        System.out.println(threadWorker.isAlive());
        System.out.println(threadWorker.getCounter());
    }
}
