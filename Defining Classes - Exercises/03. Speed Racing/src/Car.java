public class Car {
    private  String model;
    private  double fuel;
    private  double fuelcost;
    private int distanst;

    public Car(String model, double fuel, double fuelcost) {
        this.model = model;
        this.fuel = fuel;
        this.fuelcost = fuelcost;
        this.distanst=0;
    }
    public  boolean drive(int distance){
        double needFuel=this.fuelcost*distance;
        if (needFuel<=this.fuel){
            this.fuel-=needFuel;
            this.distanst+=distance;
            return false;
        }

            return true;
    }
    public double getFuel(){
        return this.fuel;
    }
    public int getDistanst(){
        return this.distanst;
    }
}
