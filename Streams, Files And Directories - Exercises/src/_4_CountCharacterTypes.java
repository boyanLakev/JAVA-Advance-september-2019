import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _4_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/input.txt";


        try (FileInputStream fis = new FileInputStream(path)) {
            int pun = 0;
            int con = 0;
            int vow = 0;

            int oneByte = fis.read();
            while (oneByte >= 0) {
                char ch = (char) oneByte;
                String chS=ch+"";
                String puntuation="!?,.";
                String vower="aoiueAOIUE";
                if(Character.isAlphabetic(ch)){
                    if(vower.contains(chS)){
                        vow++;
                    }else {
                        con++;
                    }
                }else if(puntuation.contains(chS)){
                    pun++;
                }


                oneByte = fis.read();
            }
            System.out.println("Vowels: " + vow);
            System.out.println("Consonants: " + con);
            System.out.println("Punctuation: " + pun);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
