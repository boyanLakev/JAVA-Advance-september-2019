import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String[] element = new String[input.length - 1];
        System.arraycopy(input, 1, element, 0, input.length - 1);

        ListyIterator<String> iterator = new ListyIterator<>(element);
       /* for (String s : iterator) {
            System.out.println(s);
        }*/
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            switch (line) {
                case "Move":
                    System.out.println(iterator.move());
                    break;
                case "HasNext":
                    System.out.println(iterator.hasNext());
                    break;
                case "Print":
                    try {
                        iterator.print();
                    } catch (OperationNotSupportedException e) {
                        System.out.println(e.getMessage());
                        ;
                    }
                    break;
                case "PrintAll":
                    iterator.printAll();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
