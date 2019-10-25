import java.util.Comparator;

public class Box <Type extends Comparable> {
    private Type element;
    public Box(Type element){
        this.element=element;
    }

    public Type getElement() {
        return element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName()+": " +this.element;
    }
}
