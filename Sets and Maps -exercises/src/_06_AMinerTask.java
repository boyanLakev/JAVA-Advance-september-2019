import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Long> resourse=new LinkedHashMap<>();
        while(true){
            String mineral=scanner.nextLine();
            if("stop".equals(mineral)){
                break;
            }
            long quality=Long.parseLong(scanner.nextLine());
            if (resourse.containsKey(mineral)){
                resourse.put(mineral,resourse.get(mineral)+quality);
            }else {
                resourse.put(mineral,quality);
            }
        }
        resourse.entrySet().stream()
                .forEach(e-> System.out.printf("%s -> %d%n",e.getKey(),e.getValue()));
    }
}
