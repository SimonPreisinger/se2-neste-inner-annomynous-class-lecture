public class StackHeap {

    private static void foo() {

    }

    public static void main(String... args){
        Throwable throwable = new Throwable();
        foo();
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element.getMethodName());

        }
    }

}
