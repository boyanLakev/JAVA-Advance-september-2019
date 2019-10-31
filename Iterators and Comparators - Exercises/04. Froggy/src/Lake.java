import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Lake implements Iterable<Integer> {
    private int[] stones;

    public Lake(int... stones) {
        this.stones = stones;
    }

    public class Frog implements Iterator<Integer> {
        int index = 0;

        @Override
        public boolean hasNext() {
            // if(index%2==0) return true;
            return index < stones.length;
        }

        @Override
        public Integer next() {
            int value;


            value = stones[this.index];
            index += 2;
            if (this.index % 2 == 0 && !hasNext()) {
                this.index = 1;
            }


            return value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
}
