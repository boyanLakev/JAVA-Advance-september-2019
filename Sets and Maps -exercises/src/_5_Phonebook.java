import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _5_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> phonebook=new HashMap<>();
        while(true){
            String line=scanner.nextLine();
            if("search".equals(line)){
                break;
            }
            String[] tokens=line.split("-");
            String name=tokens[0];
            String phone=tokens[1];
            phonebook.put(name,phone);

        }
        while(true){
            String name=scanner.nextLine();
            if ("stop".equals(name)){
                break;
            }
            if (phonebook.containsKey(name)){
                System.out.println(name+" -> "+phonebook.get(name));
            }else{
                System.out.printf("Contact %s does not exist.%n",name);
            }
        }

    }
}
