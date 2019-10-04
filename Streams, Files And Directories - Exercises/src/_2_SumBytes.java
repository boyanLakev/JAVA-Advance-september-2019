import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class _2_SumBytes {
    public static void main(String[] args) {
        String userPath=System.getProperty("user.dir");
        String path=userPath+"/input.txt";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line =reader.readLine();
            long sum=0;
            while(line!=null){

                for (int i = 0; i <line.toCharArray().length ; i++) {
                    sum+=line.charAt(i);
                }

                line=reader.readLine();
            }
            System.out.println(sum);

        }catch (IOException en){
            System.out.println(en);
        }
    }
}
