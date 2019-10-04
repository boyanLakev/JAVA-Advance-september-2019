import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class _12_CreateZipArchive {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");
        String path=userDir+"/input.txt";
        String pathOut=userDir+"/zip.zip";


        ZipOutputStream z=new ZipOutputStream(new FileOutputStream("zip.zip"));
        FileInputStream f=new FileInputStream("input.txt");
        z.putNextEntry(new ZipEntry("zip.zip"));
        z.write(f.readAllBytes());
        z.close();





    }
}
