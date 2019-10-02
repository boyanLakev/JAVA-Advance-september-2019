import java.io.*;
import java.util.Scanner;

public class _5_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";
        String pathOut = userDir + "/05.WriteEveryThirdLineOutput.txt";
        int count = 1;
        try (BufferedReader bfr = new BufferedReader(new FileReader(path));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {

            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (count % 3 == 0) {
                    bfw.append(line).append(System.lineSeparator());
                    bfw.flush();
                }
                count++;
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
