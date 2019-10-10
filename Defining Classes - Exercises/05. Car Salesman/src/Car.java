public class Car{
    String model;
    Engine engine;
    String weight;
    String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String string=String.format("%s:\n" +
                "%s:\n" +
                "Power: %s\n" +
                "Displacement: %s\n" +
                "Efficiency: %s\n" +
                "Weight: %s\n" +
                "Color: %s\n",this.model,engine.model,engine.power,engine.displacement,engine.efficiency,weight,color);
        return string;
    }
}