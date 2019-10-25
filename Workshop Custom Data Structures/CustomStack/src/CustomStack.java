import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private int[] item;
    private int size;
    public  final int INITIAL_CAPACITY=4;
    private int capacity;
    public CustomStack(){
        this.capacity=INITIAL_CAPACITY;
        this.item=new int[capacity];
        this.size=0;
    }
    public void puch(int element){
        ensureCapacity();
        this.item[this.size++]=element;
    }
    public int pop(){
        if(size==0){
            throw new NoSuchElementException("custom stack is epmty");
        }
        size--;
        return this.item[this.size];
    }

    private void ensureCapacity() {
        if(this.size==this.capacity){
            capacity=capacity*2;
            int[] temp=new int[capacity];
            for (int i = 0; i <this.size ; i++) {
                temp[i]=this.item[i];

            }
            this.item=temp;
        }
    }

    public int getSize(){
        return this.size;
    }
    public int peek(){
        if(size==0){
            throw new NoSuchElementException("custom stack is epmty");
        }

        return this.item[this.size];
    }
    public void forEach(Consumer<Integer> consumer){
        for (int i = this.size-1; i >=0 ; i--) {
            consumer.accept(this.item[i]);
        }

    }


}
