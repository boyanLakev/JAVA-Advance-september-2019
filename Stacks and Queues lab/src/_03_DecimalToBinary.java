import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal=Integer.valueOf(scanner.nextLine());
        if (decimal==0){
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        while(decimal!=0){
            stack.push(decimal%2);

            decimal/=2;

        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();


    }
}
