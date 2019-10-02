import java.util.Scanner;

public class _04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimention = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimention[0]);
        int cols = Integer.parseInt(dimention[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] strings = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(strings[col]);

            }

        }
        int rIndex = 0;
        int cIndex = 0;
        int bestsum = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]
                        + matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2]
                        + matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (sum > bestsum) {
                    bestsum = sum;
                    rIndex = i;
                    cIndex = j;
                }
            }
        }
        System.out.println("Sum = "+bestsum);
        System.out.printf("%d %d %d%n"
                , matrix[rIndex][cIndex]
                , matrix[rIndex][cIndex + 1]
                , matrix[rIndex][cIndex + 2]);
        System.out.printf("%d %d %d%n"
                , matrix[rIndex + 1][cIndex]
                , matrix[rIndex + 1][cIndex + 1]
                , matrix[rIndex + 1][cIndex + 2]);
        System.out.printf("%d %d %d%n"
                , matrix[rIndex + 2][cIndex]
                , matrix[rIndex + 2][cIndex + 1]
                , matrix[rIndex + 2][cIndex + 2]);
    }
}
