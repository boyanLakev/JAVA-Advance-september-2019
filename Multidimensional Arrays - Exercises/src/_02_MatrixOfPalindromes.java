import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimention=scanner.nextLine().split("\\s+");
        int rows=Integer.parseInt(dimention[0]);
        int cols=Integer.parseInt(dimention[1]);
        String [][] matrix=new String[rows][cols];
        int index=0;
        for (int i = 0; i <rows ; i++) {
            int inIndex=index;
            for (int j = 0; j <cols ; j++) {
                char outCh= (char)('a'+index);
                char inCh= (char)('a'+inIndex);

                matrix[i][j]=""+outCh+inCh+outCh;
                inIndex++;
            }
            index++;
        }
        // print
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();


        }
    }
}
