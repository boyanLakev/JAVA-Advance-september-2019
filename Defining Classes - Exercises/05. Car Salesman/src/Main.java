import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] part = scanner.nextLine().split("\\s+");
            String engineModel = part[0];
            int power = Integer.parseInt(part[1]);
            String displacement;
            String efficiency;
            if (part.length == 3) {
                if (isIntparse(part[2])) {
                    displacement = part[2];
                    efficiency = "n/a";
                } else {
                    displacement = "n/a";
                    efficiency = part[2];

                }
            } else {
                displacement = (part.length == 4) ? part[2] : "n/a";
                efficiency = (part.length == 4) ? part[3] : "n/a";
            }
            Engine engine =
                    new Engine(engineModel, power, displacement, efficiency);
            engines.add(engine);


        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] part = scanner.nextLine().split("\\s+");
            String model = part[0];
            String engine = part[1];
            String weight;
            String color;
            if (part.length == 3) {
                if (isIntparse(part[2])) {
                    weight = part[2];
                    color = "n/a";
                } else {
                    weight = "n/a";
                    color = part[2];

                }
            }else {
                weight = (part.length == 4) ? part[2] : "n/a";
                color = (part.length == 4) ? part[3] : "n/a";
            }

            for (Engine en : engines) {
                if (en.model.equals(engine)){
                    cars.add(new Car(model,en,weight,color));
                    break;
                }
            }



        }
        cars.stream().forEach(e-> System.out.print( e.toString()));
    }

    private static boolean isIntparse(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
