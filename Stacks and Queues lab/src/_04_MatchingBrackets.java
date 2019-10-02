import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string=scanner.nextLine();
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        for (int i = 0; i < string.length(); i++) {
            char ch=string.charAt(i);

            if (ch=='('){
                stack.push(i);
            }else if(ch==')'){
                int startIndex=stack.pop();
                String content=string.substring(startIndex,i+1);
                System.out.println(content);
            }

        }

    }
}
