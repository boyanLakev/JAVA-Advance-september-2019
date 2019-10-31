

public class Person implements Comparable<Person> {
    private String name;
    private int age;


    public Person(String name,int age){
        this.name=name;
        this.age=age;

    }
    @Override
    public int compareTo(Person personOther) {
        int result=this.name.compareTo(personOther.name);
        if(result==0){
            result=(this.age-personOther.age);
        }

        return result;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name+" "+this.getAge();
    }

    public String getName() {
        return this.name;
    }
}
