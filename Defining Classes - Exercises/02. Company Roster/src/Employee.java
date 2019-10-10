public class Employee {
    //name, salary, position, department, email and age.
    String name;
    double salary;
    String position;
    String department;
    String email="n/a";
    int age=-1;

    public Employee(String name, double salary, String position, String deparment, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = deparment;
        this.email = email;
        this.age = age;
    }
}
