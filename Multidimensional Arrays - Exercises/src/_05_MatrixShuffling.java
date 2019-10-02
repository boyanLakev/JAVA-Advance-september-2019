import java.util.Scanner;

public class _05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimention = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimention[0]);
        int cols = Integer.parseInt(dimention[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] strings = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = (strings[col]);

            }

        }

        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }
            String[] part = line.split("\\s+");
            if (part[0].equals("swap") && part.length == 5) {
                int x1 = Integer.parseInt(part[1]);
                int x2 = Integer.parseInt(part[2]);
                int y1 = Integer.parseInt(part[3]);
                int y2 = Integer.parseInt(part[4]);
                if ((x1 < 0 || x1 > rows) || (y1 < 0 || y1 > rows) || (x2 < 0 || x2 > cols) || (y2 < 0 || y2 > cols)) {
                    System.out.println("Invalid input!");

                } else {
                    String temp = matrix[x1][x2];
                    matrix[x1][x2] = matrix[y1][y2];
                    matrix[y1][y2] = temp;
                    // print
                    for (String[] row : matrix) {
                        for (String element : row) {
                            System.out.print(element + " ");
                        }
                        System.out.println();


                    }
                }

            } else {
                System.out.println("Invalid input!");
            }
        }

    }
}
