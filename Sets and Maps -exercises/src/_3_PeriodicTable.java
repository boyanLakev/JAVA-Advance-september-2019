import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _3_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Set<String> periodiTable=new TreeSet<>();
        for (int i = 0; i <n ; i++) {
            String[] line=scanner.nextLine().split("\\s+");
            for (int j = 0; j <line.length ; j++) {
                periodiTable.add(line[j]);
            }
        }
        for (String s : periodiTable) {
            System.out.print(s+" ");
        }
        System.out.println();

    }
}
