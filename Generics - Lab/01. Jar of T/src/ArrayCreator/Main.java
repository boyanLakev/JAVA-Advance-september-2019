package ArrayCreator;

public class Main {
    public static void main(String[] args) {
       //Integer[] number=  ArrayCreator.create(4, 1);
       String[] strings= ArrayCreator.create(String.class,5,"ab");
        for (String string : strings) {
            System.out.println(string);
        }
//        for (Integer integer : number) {
//            System.out.println(integer);
//        }
    }
}
