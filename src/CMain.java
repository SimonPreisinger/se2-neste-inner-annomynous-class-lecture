public class CMain {
    public static void main(String... args){
        C c = new C();
        C.I i = c.new I(23);
        c.foo();
        i.foo();
    }
}
