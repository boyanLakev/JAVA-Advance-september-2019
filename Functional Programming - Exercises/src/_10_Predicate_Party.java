import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_Predicate_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> names = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String line;
        while (!"Party!".equals(line = reader.readLine())) {

            String[] commandTokens = line.split("\\s+");

            String command = commandTokens[0];
            String type = commandTokens[1];
            String value = commandTokens[2];

            Predicate<String> predicate = null;
            if (type.contains("Starts")) {
                predicate = str -> !str.startsWith(value);
            } else if (type.contains("Ends")) {
                predicate = str -> !str.endsWith(value);
            } else if (type.contains("Length")) {
                predicate = str -> str.length() != Integer.parseInt(value);
            } else {
                predicate = str -> false;
            }


            if (command.contains("Remove")) {

                List<String> output = names.stream().filter(predicate).collect(Collectors.toList());
                names = output;

            } else if(command.contains("Double")){
                for (int i = 0; i < names.size(); i++) {
                    if (!predicate.test(names.get(i))) {
                        names.add(i, names.get(i));
                        i++;
                    }

                }

            }

        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            String format = String.join(", ", names);
            System.out.println(format + " are going to the party!");
        }
    }
}
