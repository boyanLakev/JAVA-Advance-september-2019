
import java.util.*;
import java.util.function.Consumer;
;

public class CustomList<T extends Object&Comparable> implements Iterable {
    private static final int INITIAL_CAPACITY = 4;
    private T[] data;
    private int size;

    public CustomList() {
        this.data = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;

    }

    public int size() {
        return this.size;
    }

    public void add(T element) {
        if (this.size == this.data.length) {
            reSize();
        }
        this.data[this.size++] = element;
    }

    private void reSize() {
        T[] newData = (T[]) new Object[this.data.length * 2];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];

        }
        this.data = newData;

    }

    public void remove(int index) {
        T element = data[index];
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size--] = null;

    }

    public boolean contains(T element) {
        boolean isPresent = false;
        for (int i = 0; i < this.size; i++) {
            if (element.equals(this.data[i])) {
                isPresent = true;
                break;
            }
        }
        return isPresent;

    }

    public void swap(int index1, int index2) {
        T temp = this.data[index1];
        this.data[index1] = this.data[index2];
        this.data[index2] = temp;
    }

    public int countGreaterThan(T element) {


        return (int) Arrays.stream(this.data, 0, size)
                .filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Arrays.stream(this.data, 0, size)
                .max(T::compareTo)
                .orElse(null);

    }

    public T getMin() {
        return Arrays.stream(this.data, 0, size)
                .min(T::compareTo)
                .orElse(null);

    }

    public void print() {
        Arrays.stream(this.data).limit(this.size).forEach(e-> System.out.println(e));
    }
    public  void sort(){
        for (int i = 0; i <size-1 ; i++) {
            for (int j = i+1; j <size ; j++) {
                if(this.data[i].compareTo(this.data[j])>0){
                    swap(i,j);
                }
            }
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }
}
