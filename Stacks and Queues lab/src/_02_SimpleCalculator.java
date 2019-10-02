import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string=scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack=new ArrayDeque<>();
        Collections.addAll(stack,string);
        while (stack.size()>1) {
            int a = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int b = Integer.parseInt(stack.pop());
            if (sign.equals("+")){
                a+=b;
            }else{
                a-=b;
            }
            stack.push(""+a);
        }
        System.out.println(stack.peek());

    }
}
