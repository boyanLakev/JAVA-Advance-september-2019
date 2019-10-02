import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;


public class _07_Crossfire {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int[] position= Arrays.stream(reader.readLine().split("\\s+"))
                 .mapToInt(Integer::parseInt)
                 .toArray();
        int rows=position[0];
        int cols=position[1];

        List<List<Integer>> matrix=new ArrayList<>();
        int count=1;
        //create matrix
        for (int i = 0; i <rows ; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j <cols; j++) {
                matrix.get(i).add(count);
                count++;
            }
        }


        while (true){
            String line=reader.readLine();
            if("Nuke it from orbit".equalsIgnoreCase(line)){
                break;
            }
            String[] tokens=line.split("\\s+");
            int row=Integer.parseInt(tokens[0]);
            int col=Integer.parseInt(tokens[1]);
            int radius=Integer.parseInt(tokens[2]);

            for (int i = col-radius; i <=col+radius ; i++) {
                if(isItBorder(row,i,matrix)){
                    matrix.get(row).set(i,0);
                }
            }

            for (int i = row-radius ; i <=row+radius ; i++) {
                if(isItBorder(i,col,matrix)){
                    matrix.get(i).set(col,0);
                }
            }
            //printMatrix(matrix);

            for (int i = 0; i <matrix.size() ; i++) {
                for (int j = 0; j <matrix.get(i).size() ; j++) {
                    if (matrix.get(i).get(j)==0){
                        matrix.get(i).remove(j);
                        j--;
                    }
                }
                if(matrix.get(i).size()==0){
                    matrix.remove(i);
                    i--;
                }
            }

           // printMatrix(matrix);

        }
        printMatrix(matrix);



    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i <matrix.size() ; i++) {
            for (int j = 0; j <matrix.get(i).size() ; j++) {
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    private static boolean isItBorder(int row, int col, List<List<Integer>> matrix) {
        boolean bul= row>=0 && col>=0 &&
                row < matrix.size() && col < matrix.get(row).size();
        return bul;

    }




}
