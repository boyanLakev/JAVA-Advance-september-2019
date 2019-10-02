
import java.util.Arrays;
import java.util.Scanner;

public class _10_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimention = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimention[0];
        int cols = dimention[1];
        char[][] board = new char[rows][cols];
        int playerCol = -1;
        int playerRow = -1;
        for (int r = 0; r < rows; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < line.toCharArray().length; c++) {
                board[r][c] = line.charAt(c);
                if (line.charAt(c) == 'P') {
                    playerCol = c;
                    playerRow = r;
                    board[r][c] ='.';
                }
            }

        }
        char[] movePlayer = scanner.nextLine().toCharArray();

        boolean win = false;
        boolean lost = false;
        for (int i = 0; i < movePlayer.length; i++) {
            int nextmoveCol = playerCol;
            int nextMoveRow = playerRow;

            switch (movePlayer[i]) {
                case 'L':
                    nextmoveCol--;
                    break;
                case 'R':
                    nextmoveCol++;
                    break;
                case 'U':
                    nextMoveRow--;
                    break;
                case 'D':
                    nextMoveRow++;
                    break;

            }
            if (isItBourd(nextMoveRow, nextmoveCol, board)) {
                if (board[nextMoveRow][nextmoveCol] == '.') {
                    playerRow = nextMoveRow;
                    playerCol = nextmoveCol;
                } else {
                    playerRow = nextMoveRow;
                    playerCol = nextmoveCol;
                    lost = true;

                }
            }else{
                win = true;


            }

            populationMuttant(board);

            if(board[playerRow][playerCol]=='B'&& !win){
                lost=true;

            }
            if (win || lost){
                break;
            }

        }

        printMatrix(board);
        if (win) {
            System.out.println("won: " + playerRow + " " + playerCol);
        }
        if (lost) {
            System.out.println("dead: " + playerRow + " " + playerCol);
        }


    }

    private static void populationMuttant(char[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '.' || board[r][c] == 'P') {
                    if (isItBourd(r - 1, c, board)) {
                        if (board[r - 1][c] == 'B') {
                            board[r][c] = '0';
                        }
                    }
                    if (isItBourd(r + 1, c, board)) {
                        if (board[r + 1][c] == 'B') {
                            board[r][c] = '0';
                        }
                    }
                    if (isItBourd(r, c - 1, board)) {
                        if (board[r][c - 1] == 'B') {
                            board[r][c] = '0';
                        }
                    }
                    if (isItBourd(r, c + 1, board)) {
                        if (board[r][c + 1] == 'B') {
                            board[r][c] = '0';
                        }
                    }
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == '0') {
                    board[r][c] = 'B';
                }
            }

        }
    }

    private static boolean isItBourd(int r, int c, char[][] board) {
        return r >= 0 && r < board.length && c >= 0 && c < board[r].length;
    }

    private static void printMatrix(char[][] picture) {
        for (char[] chars : picture) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
