import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _2_WriteToFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";
        String pathOut = userDir + "/02.WriteToFileOutput.txt";

        try (FileInputStream fis = new FileInputStream(path);
             FileOutputStream fos = new FileOutputStream(pathOut)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (oneByte != '.' && oneByte != ',' && oneByte != '?' && oneByte != '!') {
                    System.out.print(oneByte);

                    fos.write((char)oneByte);
                }
                oneByte = fis.read();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
