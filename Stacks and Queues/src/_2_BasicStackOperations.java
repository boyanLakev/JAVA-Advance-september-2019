import java.util.ArrayDeque;
import java.util.Scanner;

public class _2_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("\\s+");
        int element = Integer.parseInt(command[0]);
        int popOperation = Integer.parseInt(command[1]);
        int value = Integer.parseInt(command[2]);
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < element; i++) {
            stack.push(Integer.parseInt(tokens[i]));
        }
        for (int i = 0; i < popOperation; i++) {
            stack.pop();
        }
        if (stack.contains(value)) {
            System.out.println("true");

        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else
                System.out.println(stack.peek());
        }
    }
}
