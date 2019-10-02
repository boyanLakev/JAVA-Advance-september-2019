import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class _1_ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";

        try (FileInputStream fis = new FileInputStream(path)) {

            int  oneByte = fis.read();
            while (oneByte>=0) {

                System.out.print(Integer.toBinaryString(oneByte)+ " ");
                oneByte=fis.read();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
