public class Main {
    public static void main(String[] args) {
        CustomStack customStack=new CustomStack();
        for (int i = 0; i <5; i++) {
            customStack.puch(i);
        }
        int size=customStack.getSize();
        customStack.forEach(e-> System.out.println(e));
        for (int i = 0; i <size ; i++) {
            System.out.println(customStack.pop());
        }
    }
}
