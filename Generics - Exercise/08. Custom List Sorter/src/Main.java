import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();
        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Sort":
                    list.sort();
                    break;
                case "Add":
                    list.add(tokens[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;

                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));

                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
            }
            line = scanner.nextLine();

        }
    }
}
