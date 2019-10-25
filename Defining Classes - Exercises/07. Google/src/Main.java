import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();

        getPeople(people, br);

        String personName = br.readLine();

        System.out.println(people.get(personName));
    }

    private static void printPersonInfo(String personName, Map<String, Person> people) {


    }

    private static void getPeople(Map<String, Person> people, BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");

        while (!input[0].equals("End")){
            String name = input[0];
            people.putIfAbsent(name, new Person(name));
            String instruction = input[1];
            switch (instruction){
                case "company":
                    people.get(name).setCompany(getNewCompany(input));
                    break;
                case "car":
                    people.get(name).setCar(getNewCar(input));
                    break;
                case "pokemon":
                    people.get(name).getPokemons().add(getNewPokemon(input));
                    break;
                case "parents":
                    people.get(name).getParents().add(getNewRelative(input));
                    break;
                case "children":
                    people.get(name).getChidlren().add(getNewRelative(input));
            }

            input = br.readLine().split(" ");
        }
    }

    private static Person getNewRelative(String[] input) {
        String name = input[2];
        String birthday = input[3];
        return new Person(name, birthday);
    }

    private static Pokemon getNewPokemon(String[] input) {
        String name = input[2];
        String type = input[3];
        return new Pokemon(name, type);
    }

    private static Car getNewCar(String[] input) {
        String model = input[2];
        int speed = Integer.parseInt(input[3]);
        return new Car(model, speed);
    }

    private static Company getNewCompany(String[] input) {
        String companyName = input[2];
        String department = input[3];
        double salary = Double.parseDouble(input[4]);
        return new Company(companyName, department, salary);
    }
}
