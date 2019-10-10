import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        List<Person> list=new LinkedList<>();
        for (int i = 0; i <n; i++) {
            String[] tokens=reader.readLine().split("\\s+");
            Person person=new Person(tokens[0],Integer.parseInt(tokens[1]));

            list.add(person);
        }
        list.stream().filter(p -> p.getAge()>30)
                .sorted((a,b)-> a.getName().compareTo(b.getName()))
                .forEach(person ->
                        System.out.println(person.getName()+" - "+person.getAge()));
    }
}
