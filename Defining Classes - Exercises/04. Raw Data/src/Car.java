import java.util.List;

public class Car {
    String model;

    Engine engine;
    Cargo cargo;
    List<Tyre> tyres;

    public Car(String model, Engine engine, Cargo cargo, List<Tyre> tyres) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }
}
