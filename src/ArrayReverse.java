import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayReverse {
    /**
     * @param ArrayList<Integer>
     * @return sdfsdf
     * @throws IllegalArgumentException if redo is the first command
     */
    public ArrayList<Integer> integers;

    ArrayReverse() {
        this.integers = getStartArray();
        for (Integer i : integers)
            System.out.println("Startarray " + i);
    }

    ;

    public static void main(String... args) {
        ArrayReverse arrayReverse = new ArrayReverse();
        ArrayList<Integer> reveresd = arrayReverse.getReverseArray(arrayReverse.getStartArray());

        for (int i : reveresd)
            System.out.println("reversed" + i);
    }

    public ArrayList<Integer> getStartArray() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integers.add(i);
        }
        return integers;
    }

    /**
     * @author Simon Preisinger
     * @param orginal<Integer></Integer>  orginal
     * @return Array
     * @version 2018-05-29
     */
    public ArrayList<Integer> getReverseArray(ArrayList<Integer> orginal) {
        ArrayList<Integer> reversed = new ArrayList<>();
        ListIterator<Integer> listIter = orginal.listIterator(orginal.size());


        for (orginal.listIterator(); listIter.hasPrevious(); ) {
            Integer element = listIter.previous();
            reversed.add(element);
        }
        return reversed;
    }



}
