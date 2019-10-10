import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> list = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokes = reader.readLine().split("\\s+");
            String make = tokes[0];
            Car car = (tokes.length == 1)
                    ? new Car(make)
                    : new Car(make, tokes[1], Integer.parseInt(tokes[2]));



            /*car.setMake(make);
            car.setModel(model);
            car.setHorsePower(powerHorse);*/
            list.add(car);

        }

        list.forEach(e -> System.out.println(e.toString()));

    }
}
