import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lake lake = new Lake(Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray());
        StringBuilder sb = new StringBuilder();
        //scanner.nextLine();
        Iterator<Integer> iterator=lake.iterator();
        while(iterator.hasNext())
            sb.append(iterator.next()).append(", ");

        String result = sb.toString();


            System.out.println(result.substring(0, result.lastIndexOf(",")));


    }
}
