import java.util.Iterator;

public class Library<T> implements Iterable<T> {
    private T[] item;

    public Library(T... items){
        this.item=items;

    }
    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }

    private class LibraryIterator implements Iterator<T> {
        private int currentIndex;

        LibraryIterator(){
            this.currentIndex=0;
        }

        @Override
        public boolean hasNext() {
            return this.currentIndex+1 <= item.length;
        }

        @Override
        public T next() {
            return  item[this.currentIndex++];
        }
    }
}
