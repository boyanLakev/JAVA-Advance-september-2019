public class Main {
    public static void main(String[] args) {
        SmartArray smartArray=new SmartArray();
        for (int i = 0; i <25 ; i++) {
            smartArray.add(i);


        }
        smartArray.remove(4);
        smartArray.add(7,12);
        for (int i = 0; i <smartArray.getSize() ; i++) {
            System.out.println(smartArray.get(i));
        }
        System.out.println(smartArray.contains(3));
        smartArray.forEach(integer -> System.out.println(integer));


    }
}
