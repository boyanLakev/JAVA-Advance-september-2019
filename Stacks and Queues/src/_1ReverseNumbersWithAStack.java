import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _1ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrays= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int i : arrays) {
            stack.push(i);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();

    }
}
