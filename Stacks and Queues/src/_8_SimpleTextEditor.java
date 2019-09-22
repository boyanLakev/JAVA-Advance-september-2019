import java.util.ArrayDeque;
import java.util.Scanner;

public class _8_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "1":
                    stack.push(sb.toString());
                    sb = sb.append(command[1]);
                    break;
                case "2":
                    int count = Integer.parseInt(command[1]);
                    int start = Math.max(sb.length()  - count, 0);
                    stack.push(sb.toString());
                    sb = sb.delete(start, sb.length() );

                    break;
                case "3":
                    int index = Integer.parseInt(command[1]) ;
                    if(index<1){
                        index=1;
                    }
                    if(index>sb.length()){
                        index=sb.length();
                    }
                    if (index >=1 && index <= sb.length() ) {
                        index--;
                        char ch = sb.charAt(index);
                        System.out.println(ch);
                    }
                    break;
                case "4":
                    String string = stack.pop();
                    sb.delete(0, sb.length() );
                    sb.append(string);

                    break;
            }

        }

    }
}
