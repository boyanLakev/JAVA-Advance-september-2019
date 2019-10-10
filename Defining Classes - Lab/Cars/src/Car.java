public class Car {
    private String make;
    private String model;
    private int horsePower;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP."
                , this.getMake()
                , this.getModel()
                , this.getHorsePower());
    }

    public Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String make) {
        this.make = make;
        this.setModel("unknown");
        this.setHorsePower(-1);
    }
}
