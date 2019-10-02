import java.util.Arrays;
import java.util.Scanner;

public class _09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimention = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimention[0]);
        int cols = Integer.parseInt(dimention[1]);

        int[][] parking = new int[rows][];

        while (true) {
            String line = scanner.nextLine();
            if ("stop".equals(line)) {
                break;
            }
            int[] tokens = Arrays.stream(line.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int car = tokens[0];
            int parkRow = tokens[1];
            int parkCol = tokens[2];
            if (parking[parkRow] == null) {
                parking[parkRow] = new int[cols];

            }
            boolean fullRow = false;
            for (int i = 1; i < parking[parkRow].length; i++) {
                if (parking[parkRow][i] == 1) {
                    fullRow = true;
                } else {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                System.out.printf("Row %d full%n", parkRow);
                continue;
            }
            if (parking[parkRow][parkCol] == 1) {
                for (int i = 1; i < parking[parkRow].length; i++) {
                    if (parkCol > i && parking[parkRow][parkCol - i] != 1) {
                        parkCol -= i;
                        break;
                    }
                    if (parkCol + i < parking[parkRow].length && parking[parkRow][parkCol + i] != 1) {
                        parkCol += i;
                        break;
                    }

                }

            }
            parking[parkRow][parkCol] = 1;
            int distance = Math.abs(car - parkRow) + parkCol + 1;
            System.out.println(distance);

        }


    }

}
