import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {
    private List<T> element;
    private int index;

    public ListyIterator(T... args){
        this.element= Arrays.asList(args);
        this.index=0;
    }

    public boolean move(){
        if(this.index<this.element.size()-1){
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        return this.index<this.element.size()-1;

    }

    public void print() throws OperationNotSupportedException {
        if(this.element.size()==0){
            throw new OperationNotSupportedException("Invalid Operation!");

        }
        System.out.println(this.element.get(this.index));
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int position=0;
            @Override
            public boolean hasNext() {
                return position<element.size();
            }

            @Override
            public T next() {
                return element.get(position++) ;
            }
        };
    }
}
