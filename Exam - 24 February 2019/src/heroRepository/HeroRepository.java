package heroRepository;

import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    private List<Hero> data;

    public HeroRepository() {
        this.data = new ArrayList<>();
    }

    public void add(Hero hero) {
        this.data.add(hero);
    }

    public void remove(String name) {
        Hero hero;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                i--;
            }
        }
    }

    public Hero getHeroWithHighestStrength() {
        return this.data.stream()
                .sorted((a, b) -> b.getItem().getStrength() - a.getItem().getStrength())
                .findFirst().orElse(null);

    }
    public Hero getHeroWithHighestAgility() {
        return this.data.stream()
                .sorted((a, b) -> b.getItem().getAgility() - a.getItem().getAgility())
                .findFirst().orElse(null);

    }
    public Hero getHeroWithHighestIntelligence() {
        return this.data.stream()
                .sorted((a, b) -> b.getItem().getIntelligence()
                        - a.getItem().getIntelligence())
                .findFirst().orElse(null);

    }

    public int getCount(){
        return this.data.size();
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <this.data.size(); i++) {
            sb.append(this.data.get(i).toString());
        }
        return sb.toString();
    }
}

