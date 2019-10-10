import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class _9_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ToIntFunction<String> mapper = str -> Integer.parseInt(str);
        int[] num = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(mapper).toArray();
        Predicate<Integer> predicate = el -> {
            boolean print = true;
            for (int value : num) {
                if (el % value != 0) {
                    print = false;
                    break;
                }
            }
            return print;
        };
        for (int i = 1; i <= n; i++) {
            if (predicate.test(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }
}
