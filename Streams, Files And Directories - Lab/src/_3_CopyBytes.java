import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _3_CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";
        String pathOut = userDir + "/03.CopyBytesOutput.txt";

        try (FileInputStream fis = new FileInputStream(path);
             FileOutputStream fos = new FileOutputStream(pathOut)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                if (oneByte ==32 || oneByte ==10 ) {
                    System.out.print((char)oneByte);

                    fos.write((char)oneByte);
                }else {
                    String b=String.valueOf(oneByte);
                    for (int i = 0; i <b.toCharArray().length ; i++) {
                        System.out.print(b.charAt(i));
                        fos.write(b.charAt(i));
                    }

                }
                oneByte = fis.read();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
