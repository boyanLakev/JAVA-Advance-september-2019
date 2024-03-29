import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue=new ArrayDeque<>();
        String[] strings=scanner.nextLine().split("\\s+");
        int n=Integer.parseInt(scanner.nextLine());
        Collections.addAll(queue,strings);
        while (queue.size()>1){
            for (int i = 1; i <n ; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed "+queue.poll());
        }
        System.out.println("Last is "+queue.peek());
    }
}
