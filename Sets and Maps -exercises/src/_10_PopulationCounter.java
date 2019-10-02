import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> contries = new LinkedHashMap<>();
        Map<String, Long> population = new LinkedHashMap<>();
        //"city|country|population"
        while (true) {
            String line = scanner.nextLine();
            if ("report".equals(line)) {
                break;
            }
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int populationCity = Integer.parseInt(tokens[2]);
            if (!contries.containsKey(country)) {
                contries.put(country, new LinkedHashMap<>());
            }
            if(contries.get(country).containsKey(city)){
                contries.get(country).put(city, populationCity+contries.get(country).get(city));
            }else{
                contries.get(country).put(city, populationCity);

            }


        }
        for (Map.Entry<String, Map<String, Integer>> entry : contries.entrySet()) {
            long sumPopulation=0;
            for (Map.Entry<String, Integer> integerEntry : entry.getValue().entrySet()) {
                sumPopulation+=integerEntry.getValue();
            }
            if (!population.containsKey(entry.getKey())) {
                population.put(entry.getKey(), 0L);
            }
            population.put(entry.getKey(),sumPopulation);


        }

        population.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.println(e.getKey() + " (total population: " + e.getValue()+")");
                    contries.get(e.getKey()).entrySet().stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(element-> System.out.printf("=>%s: %d%n", element.getKey(), element.getValue()));

                });



    }
}
