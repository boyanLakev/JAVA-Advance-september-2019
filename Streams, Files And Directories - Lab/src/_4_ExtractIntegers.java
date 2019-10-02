import java.io.*;
import java.util.Scanner;

public class _4_ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";
        String pathOut = userDir + "/04.ExtractIntegersOutput.txt";
        try (Scanner scanner = new Scanner(new FileReader(path));
             PrintWriter fw = new PrintWriter(pathOut)
        ) {
            while (scanner.hasNext()) {
                scanner.next();
                if (scanner.hasNextInt()) {
                    fw.println(scanner.nextInt());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
