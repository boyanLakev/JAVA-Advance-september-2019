import java.util.Scanner;

public class TronRacers {
    private static int firstRow=0;
    private static int firstCol=0;
    private static int secondRow=0;
    private static int secondCol=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        char[][] matrix=inputMatrix(scanner,n);

        boolean isFirstAlive=true;
        boolean isSecondAlive=true;

        while (isFirstAlive && isSecondAlive){
            String[] line=scanner.nextLine().split("\\s+");
            String firstCommand=line[0];
            String secondCommand=line[1];
            moveFirstPlayer(firstCommand,matrix);
            if(matrix[firstRow][firstCol]=='x'){
                isFirstAlive=false;
                break;
            }
            moveSecondPlayer(secondCommand,matrix);
            if(matrix[secondRow][secondCol]=='x'){
                isSecondAlive=false;
            }



        }
        prinrMatrix(matrix);

    }

    private static void moveSecondPlayer(String secondCommand, char[][] matrix) {
        int n=matrix.length;
        switch (secondCommand){
            case "up":
                secondRow=frame(secondRow-1,n);
                break;
            case "down":
                secondRow=frame(secondRow+1,n);
                break;
            case "left":
                secondCol=frame(secondCol-1,n);
                break;
            case "right":
                secondCol=frame(secondCol+1,n);
                break;

        }
        char ch= matrix[secondRow][secondCol];
        if(ch !='*'){
            matrix[secondRow][secondCol]='x';

        }else {
            matrix[secondRow][secondCol]='s';
        }
    }

    private static void prinrMatrix(char[][] matrix) {
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveFirstPlayer(String firstCommand, char[][] matrix) {
        int n=matrix.length;
        switch (firstCommand){
            case "up":
                firstRow=frame(firstRow-1,n);
                break;
            case "down":
                firstRow=frame(firstRow+1,n);
                break;
            case "left":
                firstCol=frame(firstCol-1,n);
                break;
            case "right":
                firstCol=frame(firstCol+1,n);
                break;

        }
        char ch= matrix[firstRow][firstCol];
        if(ch !='*'){
            matrix[firstRow][firstCol]='x';

        }else {
            matrix[firstRow][firstCol]='f';
        }
    }

    private static int frame(int i,int n) {
        if(i==-1){
            return n-1;
        }
        if(i>=n){
            return 0;
        }
        return i;
    }


    private static char[][] inputMatrix(Scanner scanner, int n) {
        char[][] matrix=new char[n][n];
        for (int i = 0; i <n ; i++) {
            char[] row=scanner.nextLine().toCharArray();
            for (int j = 0; j <n ; j++) {
                char ch=row[j];
                matrix[i][j]=ch;
                if(ch=='f'){
                    firstRow=i;
                    firstCol=j;
                }else if(ch=='s'){
                    secondRow=i;
                    secondCol=j;
                }
            }

        }
        return matrix;
    }
}
