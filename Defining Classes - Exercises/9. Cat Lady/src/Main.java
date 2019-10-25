import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Siamese> siameseCat=new HashMap<>();
        Map<String,Cymric> cymricCat=new HashMap<>();
        Map<String,StreetExtraordinaire> streeCat=new HashMap<>();
        String line;
        while (!"End".equals(line=reader.readLine())){
            String[] tokens=line.split("\\s+");
            String breed=tokens[0];
            String name=tokens[1];
            double skill=Double.parseDouble(tokens[2]);

            switch (breed){
                case "Siamese":

                    siameseCat.put(name,new Siamese(name,skill));
                    break;
                case "Cymric":

                    cymricCat.put(name,new Cymric(name,skill));
                    break;
                case "StreetExtraordinaire":

                    streeCat.put(name,new StreetExtraordinaire(name,skill));
                    break;

            }
        }

        String name=reader.readLine();
        if(siameseCat.containsKey(name)){
            System.out.println
                    (String.format("Siamese %s %.2f",name,siameseCat.get(name).getEarSize()));
        }else if(cymricCat.containsKey(name)){
            System.out.println
                    (String.format("Cymric %s %.2f",name,cymricCat.get(name).getFurLength()));
        }else if(streeCat.containsKey(name)){
            System.out.println
                    (String.format("StreetExtraordinaire %s %.2f",name,streeCat.get(name).getDecibelsOfMeows()));
        }



    }
}
