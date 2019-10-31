import java.util.Comparator;

public class comparatorByName implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
         int result=o1.getName().length()-o2.getName().length();
         if(result==0){
             char first=Character.toLowerCase(o1.getName().charAt(0));
             char second=Character.toLowerCase(o2.getName().charAt(0));
             result=Character.compare(first,second);
         }
        return result;
    }
}
