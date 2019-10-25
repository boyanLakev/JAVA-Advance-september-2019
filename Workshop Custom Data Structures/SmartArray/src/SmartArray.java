import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY=4;
    private int[] data;
    private int size;
    private int capacity;
    public SmartArray(){
        this.data=new int[INITIAL_CAPACITY];
        this.size=0;
        this.capacity=INITIAL_CAPACITY;
    }
    public void add(int element){
        if(this.size==this.capacity){
            int[] temp =new int[this.capacity*2];
            this.capacity*=2;
            for (int i = 0; i <size ; i++) {
                temp[i]=this.data[i];

            }
            this.data=temp;
        }
        this.data[this.size]=element;
        this.size++;
        //System.arraycopy(temp,0,);
    }
    public void add(int index,int element){
        if(index<0 || index>size+1){
            throw new IndexOutOfBoundsException();
        }
        if(this.size==this.capacity){
            int[] temp =new int[this.capacity*2];
            this.capacity*=2;
            for (int i = 0; i <size ; i++) {
                temp[i]=this.data[i];

            }
            this.data=temp;
        }
        size++;

        for (int i = size; i >index ; i--) {
            this.data[i]=this.data[i-1];
        }
        this.data[index]=element;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int get(int index) {
        if(index<0 || index>=this.size){
            throw new IndexOutOfBoundsException();
        }
        return this.data[index];
    }
    public int remove(int index){
        if(index<0 || index>=this.size){
            String errMasage="Index"+index+"out of bounds";
            throw new IndexOutOfBoundsException(errMasage);
        }
        int toReturn=this.get(index);
        this.shift(index);
        if(this.capacity/this.size>=4){
            this.shring();
        }
        size--;
        return toReturn;

    }

    private void shring() {
        int[] temp =new int[this.capacity/2];
        this.capacity/=2;
        for (int i = 0; i <size ; i++) {
            temp[i]=this.data[i];

        }
        this.data=temp;

    }

    private void shift(int index){

        for (int i = index; i <this.size-1 ; i++) {
            this.data[index]=this.data[index+1];
        }

    }
    public boolean contains(int element){
        for (int i = 0; i <size+1 ; i++) {
            if(this.data[i]==element){
                return true;
            }

        }
        return false;
    }
    public void  forEach(Consumer<Integer> consumer){
        for (int i = 0; i <this.size ; i++) {
            consumer.accept(this.data[i]);
        }
    }
}
