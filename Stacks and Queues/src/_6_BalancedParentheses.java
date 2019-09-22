import java.util.ArrayDeque;
import java.util.Scanner;

public class _6_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean parebtheses=true;
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {

                if (ch == '}' || ch == ']' || ch == ')'||ch ==' '){
                    if (!stack.isEmpty()){
                        if((ch == '}' && stack.peek() == '{')
                                ||(ch == ')' && stack.peek() == '(')
                                ||(ch == ']' && stack.peek() == '[')){
                            stack.pop();

                        }else{
                            parebtheses=false;
                            break;
                        }
                    }else{
                        parebtheses=false;
                        break;
                    }
                }
            }
        }
        if (stack.isEmpty()&&parebtheses) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
