import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        Map<String,Car> map=new LinkedHashMap<>();
        while (n-->0){
            String[] tokents=reader.readLine().split("\\s+");
            Car car=new Car(tokents[0],
                    Double.parseDouble(tokents[1]),
                    Double.parseDouble(tokents[2]));
            map.putIfAbsent(tokents[0],car);

        }
        String line="";
        while(!"End".equals(line=reader.readLine())){
            String[] tokents=line.split("\\s+");
            String model=tokents[1];
            int distanst=Integer.parseInt(tokents[2]);
            if(map.get(model).drive(distanst)){
                System.out.println("Insufficient fuel for the drive");
            }


        }
        map.entrySet().forEach(e->
                System.out.printf("%s %.2f %d%n",
                        e.getKey()
                        ,e.getValue().getFuel()
                        ,e.getValue().getDistanst()));



    }
}
