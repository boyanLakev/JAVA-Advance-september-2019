public class Pokemon {
    private String name;
    private String element;
    int healt;

    public Pokemon(String name,String element,int healt){
        this.name=name;
        this.element=element;
        this.healt=healt;
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHealt() {
        return healt;
    }

    public void takeDamage(int i) {
        this.healt-=i;
    }
}
