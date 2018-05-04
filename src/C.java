public class C {
    public void foo(){
        System.out.print("foo");
    }

   // static class N { // nested Class
 //
 //
   // }

    class I { //  inner Class

        public void foo(){
            C.this.foo();
            C.this.foo();
        }


        I(int i){
            System.out.print(i);
            foo();

        }

    }
}


