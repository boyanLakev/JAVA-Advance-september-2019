import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] part = scanner.nextLine().split("\\s+");
            String model = part[0];
            int enginerSpeed = Integer.parseInt(part[1]);
            int enginerPower = Integer.parseInt(part[2]);
            int cargoWeight = Integer.parseInt(part[3]);
            String cargoType = part[4];
            List<Tyre> tyreList=new ArrayList<>() {};



            for (int j = 5; j <part.length; j+=2) {
                double pressure=Double.parseDouble(part[j]);
                int age=Integer.parseInt(part[j+1]);
                tyreList.add(new Tyre(pressure,age));

            }
            Engine engine = new Engine(enginerSpeed,enginerPower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            list.add(new Car(model, engine, cargo,tyreList ));
        }
        String command=scanner.nextLine();
        if(command.equals("fragile")){
            list.stream()
                    .filter(e-> e.cargo.type.equals("fragile"))
                    .forEach(e->{
                        double coun=e.tyres.stream().filter(tyre -> tyre.pressure<1).count();
                        if (coun!=0){
                            System.out.println(e.model);
                        }
                    });

        }else if(command.equals("flamable")){
            list.stream()
                    .filter(e-> e.cargo.type.equals("flamable"))
                    .filter(e-> e.engine.power>250)
                    .forEach(e->{

                        System.out.println(e.model);

                    });

        }
    }
}

