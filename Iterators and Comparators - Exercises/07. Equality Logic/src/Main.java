import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> treeSet=new TreeSet<>();
        Set<Person> hashSet=new HashSet<>();


        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person p=new Person(tokens[0], Integer.parseInt(tokens[1]));
            treeSet.add(p);
            hashSet.add(p);


        }
        System.out.println(treeSet.size());
        System.out.println(hashSet.size());

    }
}

