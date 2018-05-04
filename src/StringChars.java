import java.util.Iterator;

public class StringChars implements Iterable<Character> {

    public void foo(){
        new Object(){
            @Override
            public String toString() {
                return "hello from nowhere";
            }
        };
    }


    @Override
    public Iterator<Character> iterator() {
        Iterator<Character> i = new Iterator<Character>() { //annonyme Klasse
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Character next() {
                return null;
            }
        };
        return i;
    }
}
