import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String rotate = scanner.nextLine();
        rotate = rotate.substring(rotate.indexOf('(') + 1, rotate.lastIndexOf(')'));
        int graduse = Integer.parseInt(rotate) % 360;
        int cols = 0;
        while (true) {
            String line = scanner.nextLine();
            if ("END".equals(line)) {
                break;
            }
            if (cols < line.length()) {
                cols = line.length();
            }
            list.add(line);

        }
        int part = graduse / 90;

        int rows = list.size() ;
        char[][] mat=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ;
                mat[i][j] = ' ';
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                char ch = list.get(i).charAt(j);
                mat[i][j] = ch;
            }
        }

        char[][] matrix = (part == 1 || part == 3) ? new char[cols][rows] : new char[rows][cols];
        if (part == 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    matrix[i][j]=mat[i][j];
                }
            }
        }else if(part==1){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    matrix[j][rows-i-1]=mat[i][j];
                }
            }

        }else if(part==2){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    matrix[rows-i-1][cols-j-1]=mat[i][j];
                }
            }


        }else if (part==3){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    matrix[cols-j-1][i]=mat[i][j];
                }
            }


        }
        // print
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();


        }

    }
}
