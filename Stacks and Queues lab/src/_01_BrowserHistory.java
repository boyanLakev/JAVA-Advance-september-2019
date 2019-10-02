import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (true) {
            String line = scanner.nextLine();
            if ("Home".equalsIgnoreCase(line)) {
                break;
            }
            if ("back".equalsIgnoreCase(line)) {
                if (stack.size()<2) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            } else {
                stack.push(line);
                System.out.println(stack.peek());
            }
        }
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }

    }

}
