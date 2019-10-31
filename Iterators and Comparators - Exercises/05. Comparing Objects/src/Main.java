import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            people.add(new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));

            line = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine())-1;
        int count = 0;
        Person person = people.get(index);


        for (Person p : people) {
            if(p.compareTo(person)==0){
                count++;
            }
        }

        if(count==1){
            System.out.println("No matches");
        }else {
            System.out.printf("%d %d %d%n",count,people.size()-count,people.size());
        }

    }
}
