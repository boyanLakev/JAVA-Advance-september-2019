import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _8_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split("\\s+");
        Integer[] num = new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        Comparator<Integer> comparator = (f, s) -> {
            int sort;
            if (f % 2 == 0 && s % 2 != 0) {
                sort = -1;
            } else if (f % 2 != 0 && s % 2 == 0) {
                sort = 1;
            } else {
                sort = f - s;
            }
            return sort;
        };
        Arrays.sort(num,comparator);
        for (Integer i : num) {
            System.out.print(i + " ");

        }
    }
}
