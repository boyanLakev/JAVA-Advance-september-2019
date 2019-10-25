import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Person> parents;
    private List<Person> chidlren;
    private List<Pokemon> pokemons;
    private String birthday = null;


    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.chidlren = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChidlren() {
        return chidlren;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public String toString() {
        return String.format(
                "%s%n" +
                        "Company:%n%s" +
                        "Car:%n%s" +
                        "Pokemon:%n%s" +
                        "Parents:%n%s" +
                        "Children:%n%s",
                this.name,
                this.company != null ? this.company : "",
                this.car != null ? this.car : "",
                this.pokemons.size() > 0 ? getPokemonsOutput() : "",
                this.parents.size() > 0 ? getRelativesOutput(this.parents) : "",
                this.chidlren.size() > 0 ? getRelativesOutput(this.chidlren) : ""
        );
    }

    private String getRelativesOutput(List<Person> relative) {
        StringBuilder output = new StringBuilder();
        relative.forEach(r -> {
            String line = String.format("%s %s%n", r.getName(), r.getBirthday());
            output.append(line);
        });
        return output.toString();
    }

    private String getPokemonsOutput() {
        StringBuilder output = new StringBuilder();
        this.pokemons.forEach(p -> output.append(p.toString()));
        return output.toString();
    }
}
