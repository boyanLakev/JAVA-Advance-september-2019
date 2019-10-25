import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        String name=line.substring(0,line.lastIndexOf(" "));
        String address=line.substring(line.lastIndexOf(" ")+1);
        Tuple<String,String> tuple=new Tuple<>(name,address);
        System.out.println(tuple.toString());

        line=scanner.nextLine();
        name=line.split("\\s+")[0];
        Integer beer=Integer.parseInt(line.split("\\s+")[1]);
        Tuple<String,Integer> tuple1=new Tuple<>(name,beer);
        System.out.println(tuple1.toString());

        line=scanner.nextLine();
        Integer integere=Integer.parseInt(line.split("\\s+")[0]);;
        Double doublenum=Double.parseDouble(line.split("\\s+")[1]);
        Tuple<Integer,Double> tuple2=new Tuple<>(integere,doublenum);

        System.out.println(tuple2.toString());


    }
}
