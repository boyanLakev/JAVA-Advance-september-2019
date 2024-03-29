import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.temporal.JulianFields;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _6_SortLines {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get( userDir + "/input.txt");
        Path pathout =Paths.get( userDir + "/06.SortLinesOutput.txt");
        List<String> list= Files.readAllLines(path);

        Collections.sort(list);
        Files.write(pathout,list);


    }
}
