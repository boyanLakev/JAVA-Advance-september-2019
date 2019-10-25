package jar;

import java.util.ArrayDeque;

/**
 *
 * @param <T>
 */
public class Jar<T> {
    public ArrayDeque<T> data;
    public Jar(){
        this.data=new ArrayDeque<>();
    }

    public void add(T element) {
        this.data.push(element);
    }

    public T remove() {
      return this.data.pop();
    }
}
