import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Integer[] a=new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            a[i]=array[i];
        }

        int n=Integer.parseInt(scanner.nextLine());
        Predicate<Integer> predicate= e-> e % n !=0;
        Comparator<Integer> comparator=(f,s)->-1;

        Arrays.stream(a)
                .filter(predicate)
                .sorted(comparator)
                .forEach(e-> System.out.print(e+" "));


    }
}
