import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _9_CopyAPicture {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String path=userDir+"/image.jpg";
        String pathOut=userDir+"/copyImage.jpg";
        try {
            FileInputStream f=new FileInputStream(path);
            byte[] image=f.readAllBytes();
            FileOutputStream s=new FileOutputStream(pathOut);
            s.write(image);
            f.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
