import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

public class _12_LegengaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> mainMap = new HashMap<>();
        mainMap.put("shards", 0);
        mainMap.put("fragments", 0);
        mainMap.put("motes", 0);
        Map<String, String> legend = new HashMap<>();
        legend.put("shards", "Shadowmourne");
        legend.put("fragments", "Valanyr");
        legend.put("motes", "Dragonwrath");


        Map<String, Integer> secondMap = new HashMap<>();
        boolean exit = false;
        while (true) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int value = Integer.parseInt(tokens[i]);
                String type = tokens[i + 1].toLowerCase();
                if (mainMap.containsKey(type)) {
                    mainMap.put(type, mainMap.get(type) + value);
                    if (mainMap.get(type) >= 250) {
                        System.out.println(legend.get(type) + " obtained!");
                        mainMap.put(type, mainMap.get(type) - 250);
                        exit = true;
                        break;
                    }
                } else {
                    if (!secondMap.containsKey(type)) {
                        secondMap.put(type, 0);
                    }
                    secondMap.put(type, secondMap.get(type) + value);
                }

            }
            if (exit) {
                break;
            }

        }
        mainMap.entrySet().stream().sorted((e1, e2) -> {
            int sort = e2.getValue().compareTo(e1.getValue());
            if (sort == 0) {
                sort = e1.getKey().compareTo(e2.getKey());

            }
            return sort;
        }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        secondMap.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sort = e1.getKey().compareTo(e2.getKey());
                    return sort;
                }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
