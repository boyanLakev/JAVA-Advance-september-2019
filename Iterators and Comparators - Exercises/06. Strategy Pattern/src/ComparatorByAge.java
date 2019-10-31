import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {

        return f.getAge()-s.getAge();
    }
}
