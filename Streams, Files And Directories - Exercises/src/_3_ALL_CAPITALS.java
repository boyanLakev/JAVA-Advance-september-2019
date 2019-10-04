import java.io.*;

public class _3_ALL_CAPITALS {
    public static void main(String[] args) throws IOException {

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";
        String pathOut = userDir + "/output.txt";

        try (BufferedReader bfr = new BufferedReader(new FileReader(path));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {

            String line = "";
            while ((line = bfr.readLine()) != null) {
                    line=line.toUpperCase();
                    bfw.append(line).append(System.lineSeparator());
                    bfw.flush();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
