package heroRepository;

public class Hero {
    private  String name;
    private int level;
    private Item item;

    public Hero(String name,int level,Item item){
        this.name=name;
        this.level=level;
        this.item=item;
    }

    public String getName(){
        return this.name;
    }
    public int getLevel(){
        return this.level;
    }
    public Item getItem(){
        return this.item;
    }

    @Override
    public String toString() {
        return String.format("Hero: %s – %d%n"+
                "  * Strength: %d%n"+
                "  * Agility: %d%n"+
                "  * Intelligence: %d%n"
                ,this.name,this.level
                ,this.item.getStrength()
                ,this.item.getAgility()
                ,this.item.getIntelligence()
        );
    }
}
