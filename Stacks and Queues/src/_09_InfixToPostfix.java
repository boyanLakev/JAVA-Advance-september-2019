import java.util.ArrayDeque;
import java.util.Scanner;

public class _09_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> line = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            line.offer(input[i]);
        }
        ArrayDeque<String> postFix = new ArrayDeque<>();
        ArrayDeque<String> operator = new ArrayDeque<>();
        while (!line.isEmpty()) {
            String current = line.poll();
            String[] digit=current.split("[0-9a-z]");
            if (digit.length==0) {
                postFix.offer(current);
            } else {
                if (current.equals("(")) {
                    operator.push(current);
                } else if (current.equals(")")) {
                    while (true) {
                        String sing = operator.pop();
                        if (sing.equals("(")) {
                            break;
                        }
                        postFix.offer(sing);

                    }
                }else if (current.equals("*")||current.equals("/")){
                    if (operator.isEmpty()){
                        operator.push(current);
                    }else if(operator.peek().equals("*")
                            ||operator.peek().equals("/")
                    ){
                        postFix.offer(operator.pop());
                        operator.push(current);

                    }else{
                        operator.push(current);
                    }
                }else if(current.equals("+")||current.equals("-")){
                    if (operator.isEmpty()){
                        operator.push(current);
                    }else if(operator.peek().equals("*")
                            ||operator.peek().equals("/")
                            ||operator.peek().equals("+")
                            ||operator.peek().equals("-")){
                        postFix.offer(operator.pop());
                        operator.push(current);

                    }else{
                        operator.push(current);
                    }
                }
            }

        }
        while (!operator.isEmpty()){
            postFix.offer(operator.pop());
        }
        String string="";
        while(!postFix.isEmpty()){
            string+=postFix.pop()+" ";
        }
        System.out.println(string);

    }
}
