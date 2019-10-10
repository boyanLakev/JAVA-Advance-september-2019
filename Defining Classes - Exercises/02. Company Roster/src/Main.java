import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> list = new ArrayList<>();
        List<String> deparmens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] part = scanner.nextLine().split("\\s+");
            String name = part[0];
            double salary = Double.parseDouble(part[1]);
            String position = part[2];
            String deparment = part[3];
            int age=-1;
            String email;
            if (part.length == 5){
                if(tryParse(part[4])){
                    age=Integer.parseInt(part[4]);
                    email="n/a";
                }else{
                    email=part[4];
                }
            }else{
                email = ( part.length==6) ? part[4] : "n/a";
                age = (part.length == 6) ? Integer.parseInt(part[5]) : -1;}
            Employee x = new Employee(name, salary, position, deparment, email, age);
            list.add(x);
            if (!deparmens.contains(deparment)) {
                deparmens.add(deparment);
            }


        }
        String[] bestDeparment=new String[1];
        double bestAvr = -1;
        for (String deparmen : deparmens) {
            int count = 0;
            double sum = 0;
            for (Employee emp : list) {
                if (emp.department.equals(deparmen)) {
                    count++;
                    sum += emp.salary;
                }
            }
            if (count > 0) {
                double avr = sum / count;
                if (avr>bestAvr){
                    bestDeparment[0]=deparmen;
                    bestAvr=avr;
                }
            }

        }
        System.out.println("Highest Average Salary: "+bestDeparment[0]);

        list.stream().filter(e-> bestDeparment[0].equals(e.department))
                .sorted((e1,e2)-> Double.compare(e2.salary,e1.salary))
                .forEach(e-> {
                    String formatSalary=String.format("%.2f",e.salary).replace(",",".");
                    System.out.printf("%s %s %s %d%n",e.name,formatSalary,e.email,e.age);
                });



    }

    private static boolean tryParse(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}


