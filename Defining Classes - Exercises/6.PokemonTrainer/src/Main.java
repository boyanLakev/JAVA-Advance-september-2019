import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            String[] tokens = line.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int healt = Integer.parseInt(tokens[3]);
            Trainer trainer = new Trainer(trainerName);
            Pokemon pokemon = new Pokemon(pokemonName, element, healt);
            trainers.putIfAbsent(trainerName, trainer);
            trainers.get(trainerName).addPokemon(pokemon);

            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!"End".equals(line)) {
            String element = line;
            for (Trainer trainer : trainers.values()) {
                if (trainer.hasElementType(element)) {
                    trainer.badgeIcrement();
                } else {
                    trainer.damagePokemon(10);
                }
            }

            line = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((f, s) -> s.getValue().getBadget() - f.getValue().getBadget())
                .forEach(entry-> System.out.println(entry.getValue().toString()));
        ;

    }
}
