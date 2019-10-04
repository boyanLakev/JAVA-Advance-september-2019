import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1_SumLines {
    public static void main(String[] args) {
        String userPath=System.getProperty("user.dir");
        String path=userPath+"/input.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line =reader.readLine();
            while(line!=null){
                int sum=0;
                for (int i = 0; i <line.toCharArray().length ; i++) {
                    sum+=line.charAt(i);
                }
                System.out.println(sum);
                line=reader.readLine();
            }

        }catch (IOException en){
            System.out.println(en);
        }
    }
}
