import java.util.Scanner;

public class _11_ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimention = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimention[0]);
        int cols = Integer.parseInt(dimention[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] strings = scanner.nextLine().split("\\s");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = strings[col];

            }

        }


        int col=cols-1;
        while (col >=0 ) {
            int c=col;
            int r=rows-1;
            while (isItBorder(r,c,matrix)){
                System.out.print(matrix[r][c]+" ");
                r--;
                c++;

            }
            col--;
            System.out.println();
        }
        int row=rows-2;

        while ( row >=0 ) {
            int c=0;
            int r=row;
            while (isItBorder(r,c,matrix)){
                System.out.print(matrix[r][c]+" ");
                r--;
                c++;

            }
            row--;
            System.out.println();
        }




    }

    private static boolean isItBorder(int r, int c, String[][] matrix) {
        return r >= 0 && r < matrix.length &&
                c >= 0 && c < matrix[r].length;
    }
}
