import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> peopleByAge=new TreeSet<>(new ComparatorByAge());
        Set<Person> peopleByName=new TreeSet<>(new comparatorByName());


        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person p=new Person(tokens[0], Integer.parseInt(tokens[1]));
            peopleByName.add(p);
            peopleByAge.add(p);


        }
        //Collections.sort(people, new comparatorByName());
        for (Person person : peopleByName) {
            System.out.println(person.toString());
        }
        //Collections.sort(people, new ComparatorByAge());
        for (Person person : peopleByAge) {
            System.out.println(person.toString());
        }

    }
}
