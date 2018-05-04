interface Printable{
    void priint();
}
public class Closure {
    static Printable foo(int i){
        // int i = 23; //wird in den Heap übertrangen und überlebt deshalb
        return new Printable() {
            @Override
            public void priint() {
                System.out.print("printing: " + i);
            }
        };
    }

    public static void main(String... args) throws InterruptedException {
        Printable p = foo(23);
        Thread.sleep(1000);
        p.priint();
        p.priint();
        System.out.print(p.getClass());
        Printable q = foo(234);
        q.priint();
    }
}
