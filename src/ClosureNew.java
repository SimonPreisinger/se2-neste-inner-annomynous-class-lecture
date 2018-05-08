public class ClosureNew {
    public static void main(String... args) {
        Runnable r; // macht sozusagen photo snapshot mit variablen i usw
        {
            int i = 1;
            r = new Runnable() {

                @Override
                public void run() {
                    System.out.println(i);
                }
            };
        }
        {
        // int i = 2; //anderes I als in runnable
        r.run();

        }
    }
}
