import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _8_GetFolderSize {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String path=userDir+"/Exercises Resources";
        //Path path = Paths.get( userDir + "/Exercises Resources");
        //Path pathout =Paths.get( userDir + "/output.txt");
        File[] f=new File(path).listFiles();
        int sum=0;
        for (File file : f) {
            sum+=file.length();
        }
        System.out.println(sum);
    }
}
