import java.util.Iterator;
import java.util.function.Consumer;

@FunctionalInterface
interface Block{
    void hello(int x);
}


public class Lambda {
   // public void print(){  // ohne Lambda Ausruck
   //     System.out.println(42);
   // }
    static void printStars(){
        System.out.println("****");
    }

    public static void main(String... args){ // Lamdba zum speichern, Aufrüuf einer Methode von überall
      //  Runnable r; // interface darf nur eine Methode haben
      //  r = () -> {System.out.println(42); // interface mit Methode mit gleicher Anzahl parameter z.B. Runnable bei  ()
      //  };
//
      //  Block b;
      //  b = () -> {System.out.println(41);
      //  };
      //  r.run();
      //  b.hello();

        // Consumer<Integer> doublePrinter = (Integer i) -> {System.out.println(2*i);};
        Block b = (int i) -> {System.out.println(2*i);}; // kein Objekt, blanker Byte Code nicht im HEAP, schnell
        b.hello(42);

        b = (i) -> {
            System.out.println(2*i);
        };
        b = i -> {  // typ kann man weglassen, bei nur einem Parameter, Compiler erstellt Klammern
            System.out.println(2*i);
        };

        b = i ->  // Bei Anweisung kann Klammer weggelassen werden
            System.out.println(2*i);
        ;
        Block b4 = i -> System.exit(1);
        b4.hello(5);

        Block b5 = i -> printStars();
        printStars();
        System.out.println("I am happy");

        Block b2 = new Block() { // neues Object, this
            @Override
            public void hello(int x) {
                System.out.println(2 * x);
            };
        };

        Block b3;{
            int j = 4;
            b3 = i -> {
                printStars();
                System.out.println(j * i);
        };

        }
        b3.hello(42);
        Block a = new Block() {
            @Override
            public void hello(int x) {
                System.out.println("blah");
            }
        };
    }
}
