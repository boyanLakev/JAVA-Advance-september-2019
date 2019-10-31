import javax.naming.OperationNotSupportedException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        StackIterator<String> stack=new StackIterator<>();

        String line = scanner.nextLine();
        boolean puchUse=false;
        boolean popUse=false;

        while (!line.equals("END")) {
            if(line.equals("Pop")){
                try {
                    stack.pop();
                     popUse=true;
                } catch (OperationNotSupportedException e) {
                    System.out.println(e.getMessage());
                }
            }else{
                String[] input = line.split("[, ]+");
                String[] element = new String[input.length - 1];
                System.arraycopy(input, 1, element, 0, input.length - 1);
                stack.push(element);
                puchUse=true;
            }
            /*if(popUse && puchUse){
                popUse=false;
                puchUse=false;
                for (Object o : stack) {
                    System.out.println(o);
                }
            }*/
            line = scanner.nextLine();
        }
        for (Object o : stack) {
            System.out.println(o);
        }
        for (Object o : stack) {
            System.out.println(o);
        }
    }
}
