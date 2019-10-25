import java.util.*;

public class Trainer {
    private String name;
    private int badget;
    private Map<String,List<Pokemon>> pokemons;

    public Trainer(String name){
        this.name=name;
        this.badget=0;
        this.setPokemon();
    }
    private void setPokemon(){
        this.pokemons=new HashMap<>();
        this.pokemons.put("Fire",new ArrayList<>());
        this.pokemons.put("Water",new ArrayList<>());
        this.pokemons.put("Electricity",new ArrayList<>());

    }

    public String getName() {
        return name;
    }

    public int getBadget() {
        return badget;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.putIfAbsent(pokemon.getElement(),new ArrayList<>());
        this.pokemons.get(pokemon.getElement()).add(pokemon);


    }

    public boolean hasElementType(String element) {
        return !this.pokemons.get(element).isEmpty();
    }

    public void badgeIcrement() {
        this.badget+=1;
    }

    public void damagePokemon(int i) {
        for (List<Pokemon> pok : pokemons.values()) {
            for (Pokemon pokemon : pok) {
                pokemon.takeDamage(i);
            }
        }
        this.clearPokemon();
    }
    public  void clearPokemon(){
        for (List<Pokemon> value : pokemons.values()) {
            value.removeIf(p-> p.getHealt()<=0);
        }
    }
    private int count(){
        int side=0;
        for (List<Pokemon> value : pokemons.values()) {
            side+=value.size();
        }
        return side;
    }

    @Override
    public String toString() {


        return String.format("%s %d %d",getName(),getBadget(),this.count());
    }
}
