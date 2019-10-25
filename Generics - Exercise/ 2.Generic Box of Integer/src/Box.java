public class Box<Type> {
    private Type element;

    public Box(Type element){
        this.element=element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName()+": "+this.element;
    }
}
