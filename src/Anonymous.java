public class Anonymous {
    static abstract class Base{
        Base(int x){
            System.out.println(x);
        }
        abstract void print();
    }

    interface I {
        I foo();
    }

    public static void main(String... args){
        Base b = new Base(23){

            @Override
            void print() {

            }
        };
        b.print();


        I i = new I(){

            public I foo(){
                return  this;
            }

            void bar(){ // Methode ist nicht erreichbar  außer: I i = weglassen
                System.out.println("bar");
            }
        };
        i.foo();
        I j = i.foo();

    }
}
