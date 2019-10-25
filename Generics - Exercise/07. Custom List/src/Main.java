import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();
        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
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
//        •	Add <element> - Adds the given element to the end of the list
//•	Remove <index> - Removes the element at the given index
//•	Contains <element> - Prints if the list contains the given element (true or false)
//•	Swap <index> <index> - Swaps the elements at the given indexes
//•	Greater <element> - Counts the elements that are greater than the given element and prints their count
//•	Max - Prints the maximum element in the list
//•	Min - Prints the minimum element in the list
//•	Print - Prints all elements in the list, each on a separate line
//•	END - stops
//
        }

    }

}
