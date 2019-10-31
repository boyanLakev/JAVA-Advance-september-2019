import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StackIterator <T> implements Iterable{
    private List<T> element;
    int index;

    public StackIterator(){
        this.element= new ArrayList<>();
        this.index=-1;
    }

    public void push(T... args){
        for (int i = 0; i <args.length ; i++) {
            this.element.add(args[i]);
            this.index++;
        }
    }


    public T pop() throws OperationNotSupportedException {
        if(index==-1){
            throw new OperationNotSupportedException("No elements");

        }
        return this.element.remove(this.index--);
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int position=index;
            @Override
            public boolean hasNext() {
                return position>=0;
            }

            @Override
            public Object next() {
                return element.get(position--);
            }
        };
    }
}
