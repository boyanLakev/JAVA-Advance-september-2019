import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setSize= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Set<Integer> set1=new LinkedHashSet<>();
        Set<Integer> set2=new LinkedHashSet<>();

        for (int i = 0; i <setSize[0] ; i++) {
            set1.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i <setSize[1] ; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));
        }
        Set<Integer> setAnd=new LinkedHashSet<>();
        for (Integer i : set1) {
            if (set2.contains(i)){
                setAnd.add(i);
            }
        }
        //print
        for (Integer i : setAnd) {
            System.out.print(i +" ");
        }


    }
}
