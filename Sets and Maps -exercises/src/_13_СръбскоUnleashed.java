import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_СръбскоUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String,Integer>> cityMap=new LinkedHashMap<>();
        while (true){
            String line=scanner.nextLine();
            if("End".equalsIgnoreCase(line)){
                break;
            }
            Pattern pattern=Pattern.compile("([A-Za-z ]+)[ ][@]([A-Za-z ]+)[ ](\\d+)[ ](\\d+)$");
            Matcher matcher=pattern.matcher(line);
            if (matcher.find()){
                String artist=matcher.group(1);
                String city=matcher.group(2);
                int price=Integer.parseInt(matcher.group(3));
                int count=Integer.parseInt(matcher.group(4));
                if (!cityMap.containsKey(city)){
                    cityMap.put(city,new LinkedHashMap<>());
                }
                if (!cityMap.get(city).containsKey(artist)){
                    cityMap.get(city).put(artist, 0);
                }
                cityMap.get(city).put(artist, price*count+cityMap.get(city).get(artist));

            }
        }
        cityMap.entrySet().stream()
                .forEach(e->{
                    System.out.println(e.getKey());

                    e.getValue().entrySet().stream()
                            .sorted((a,b)-> b.getValue().compareTo(a.getValue()))
                            .forEach(art-> System.out.printf("#  %s -> %d%n",art.getKey(),art.getValue()));
                });
    }
}
