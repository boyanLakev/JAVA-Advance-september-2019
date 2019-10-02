import java.util.Arrays;
import java.util.Scanner;

public class _12_TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimention= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows=dimention[0];
        int cols=dimention[1];
        char[][] picture=new char[rows][cols];
        for (int r = 0; r <rows ; r++) {
            String[] currentCol=scanner.nextLine().split("\\s+");
            for (int c = 0; c <cols ; c++) {
                picture[r][c]=currentCol[c].charAt(0);
            }

        }
        char insert=scanner.nextLine().charAt(0);
        int[] point= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int xPoint=point[0];
        int yPoint=point[1];
        char old=picture[xPoint][yPoint];
        floorFill(xPoint,yPoint,insert,old,picture);
        printMatrix(picture);


    }

    private static void printMatrix(char[][] picture) {
        for (char[] chars : picture) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void floorFill(int x, int y, char newcolor,char old, char[][] picture) {
        if(x<0 || y<0 || x>picture.length-1 || y>picture[x].length-1){
            return;
        }
        if (picture[x][y] != old){
            return;
        }
        picture[x][y]=newcolor;
        floorFill(x-1,y,newcolor,old,picture);
        floorFill(x+1,y,newcolor,old,picture);
        floorFill(x,y-1,newcolor,old,picture);
        floorFill(x,y+1,newcolor,old,picture);
        return;

    }
}
