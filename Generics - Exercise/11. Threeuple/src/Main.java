import java.awt.geom.Arc2D;
import java.util.Scanner;
import java.util.function.DoubleBinaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        String town=line.substring(line.lastIndexOf(" ")+1);
        line=line.substring(0,line.lastIndexOf(" "));
        String address=line.substring(line.lastIndexOf(" ")+1);
        String name=line.substring(0,line.lastIndexOf(" "));
        Threeuple<String,String,String> threeuple1=
                new Threeuple<>(name,address,town);
        System.out.println(threeuple1);

        String[] tokens=scanner.nextLine().split("\\s+");
        name=tokens[0];
        Integer beer=Integer.parseInt(tokens[1]);
        Boolean drubnk=("drunk".equals(tokens[2]))?true:false;
        Threeuple<String,Integer,Boolean> threeuple2=
                new Threeuple<>(name,beer,drubnk);
        System.out.println(threeuple2);

         tokens=scanner.nextLine().split("\\s+");
        name=tokens[0];
        Double ballance= Double.parseDouble(tokens[1]);
        String bank=tokens[2];
        Threeuple<String,Double,String> threeuple3=
                new Threeuple<>(name,ballance,bank);
        System.out.println(threeuple3);

    }
}
