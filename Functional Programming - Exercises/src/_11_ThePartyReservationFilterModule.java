import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class _11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split("\\s+");

        HashMap<String, Predicate<String>> map = new HashMap<>();
        String command = scanner.nextLine();
        while (!"Print".equals(command)) {
            String[] tokens = command.split(";");
            String criteria = tokens[2];

            String type = tokens[1];
            String filterName = type + criteria;

                Predicate<String> predicate = null;
                if (type.contains("Starts")) {
                    predicate = str -> str.startsWith(criteria);
                } else if (type.contains("Ends")) {
                    predicate = str -> str.endsWith(criteria);
                } else if (type.contains("Length")) {
                    predicate = str -> str.length() == Integer.parseInt(criteria);
                } else {
                    predicate = str -> str.contains(criteria);
                }
            if (tokens[0].contains("Add")) {
                map.putIfAbsent(filterName, predicate);


            } else {
                map.remove(filterName);

            }
            command = scanner.nextLine();
        }
        boolean[] notFilter = new boolean[1];
        Arrays.stream(names).forEach(e -> {

            notFilter[0]=true;
            map.forEach((k,v) -> {

                if (v.test(e)) {

                    notFilter[0] = false;
                }
            });

            if (notFilter[0]) {
                System.out.print(e + " ");
            }


        });
        System.out.println();

    }
}
