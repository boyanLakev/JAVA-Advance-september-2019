import java.util.Scanner;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int[][] matrix=new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] strings=scanner.nextLine().split("\\s");
            for (int col = 0; col < n; col++) {
                matrix[row][col]=Integer.parseInt(strings[col]);

            }

        }
        int fistDia=0;
        int secondDia=0;
        for (int i = 0; i <n; i++) {
            fistDia+=matrix[i][i];
            secondDia+=matrix[n-i-1][i];
        }
        int sum=Math.abs(fistDia-secondDia);
        System.out.println(sum);
    }
}
