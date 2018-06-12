public class ConcurrencyRunnable {
    public static void main(String... args) throws InterruptedException {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);
        thread.start();
        thread.join();
        System.out.println(worker.getResut());
    }
}
