import java.util.Scanner;

public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMattrix = Integer.parseInt(scanner.nextLine());

        char[][] matrix = readMatrix(scanner, sizeMattrix);

        int playerRow = getFirstRowSymbol('S', matrix);
        int playerCol = getFirstColSymbol('S', playerRow, matrix);

        boolean isInVoid = false;
        int power = 0;
        while (!isInVoid) {
            if (power >= 50) {
                break;
            }
            String direction = scanner.nextLine();
            int currentRow = playerRow;
            int currentCol = playerCol;

            switch (direction) {
                case "up":
                    currentRow -= 1;
                    break;
                case "down":
                    currentRow += 1;
                    break;
                case "left":
                    currentCol -= 1;
                    break;
                case "right":
                    currentCol += 1;
                    break;
            }
            // is in galaxy
            isInVoid = IsInGalaxy(currentRow, currentCol, matrix.length);

            if (isInVoid) {
                matrix[playerRow][playerCol] = '-';
                break;
            }

            char currentSymbol = matrix[currentRow][currentCol];
            //
            if (currentSymbol == '-') {
                matrix[playerRow][playerCol] = '-';
                matrix[currentRow][currentCol] = 'S';
                playerRow = currentRow;
                playerCol = currentCol;
            } else if (Character.isDigit(currentSymbol)) {
                matrix[playerRow][playerCol] = '-';
                matrix[currentRow][currentCol] = 'S';
                playerRow = currentRow;
                playerCol = currentCol;

                power += ((int) currentSymbol - '0');

            } else if (currentSymbol == 'O') {
                matrix[playerRow][playerCol] = '-';
                matrix[currentRow][currentCol] = '-';
                currentRow = getFirstRowSymbol('O', matrix);
                currentCol = getFirstColSymbol('O', currentRow, matrix);
                matrix[currentRow][currentCol] = 'S';
                playerRow = currentRow;
                playerCol = currentCol;


            }


        }
        if (isInVoid) {
            System.out.println("Bad news, the spaceship went to the void.");
        } else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");

        }
        System.out.println("Star power collected: " + power);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean IsInGalaxy(int row, int col, int size) {

        boolean isInGalaxy = row < 0 || row > size - 1 || col < 0 || col > size - 1;

        return isInGalaxy;
    }

    private static int getFirstColSymbol(char s, int playerRow, char[][] matrix) {
        int index = -1;
        for (int i = 0; i < matrix[playerRow].length; i++) {
            if (matrix[playerRow][i] == s) {
                index = i;
                break;
            }
        }
        return index;
    }

    private static int getFirstRowSymbol(char s, char[][] matrix) {
        int index = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == s) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                break;
            }

        }
        return index;
    }

    private static char[][] readMatrix(Scanner scanner, int sizeMattrix) {
        char[][] matrix = new char[sizeMattrix][sizeMattrix];
        for (int i = 0; i < sizeMattrix; i++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[i] = row;
        }
        return matrix;

    }
}
