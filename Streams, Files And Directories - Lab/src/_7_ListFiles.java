import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _7_ListFiles {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File f=new File(userDir +"/Files-and-Streams");
        File[] allFile=f.listFiles();
        for (File file : allFile) {

                if(!file.isDirectory()){
                    System.out.printf("%s: [%d]%n",file.getName(),file.length());
                }

        }
    }
}
