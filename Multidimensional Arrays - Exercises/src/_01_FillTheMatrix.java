import java.util.Scanner;

public class _01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        char type = input[1].charAt(0);
        int[][] matrix = new int[n][n];
        if (type == 'a' || type == 'A') {
            int index = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = index;
                    index++;
                }
            }
        } else {
            int index = 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++) {
                        matrix[j][i] = index;
                        index++;
                    }
                }else{
                    for (int j = n-1; j >=0; j--) {
                        matrix[j][i] = index;
                        index++;
                    }
                }
            }

        }
        // print
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();


        }

    }
}
