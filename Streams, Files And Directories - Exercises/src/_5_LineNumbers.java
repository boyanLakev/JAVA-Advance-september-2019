import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _5_LineNumbers {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get( userDir + "/inputLineNumbers.txt");
        Path pathout =Paths.get( userDir + "/output.txt");
        List<String> list= Files.readAllLines(path);
        for (int i = 0; i <list.size() ; i++) {
            list.set(i,i+". "+list.get(i));
            System.out.println(list.get(i));
        }


        Files.write(pathout,list);


    }


}
