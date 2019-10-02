import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _4_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string=scanner.nextLine();
        Map<Character,Integer> map=new TreeMap<>();
        for (char c : string.toCharArray()) {
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            map.put(c,map.get(c)+1);
        }
        map.forEach((k,v)-> System.out.printf("%s: %d time/s%n",k,v) );


    }
}
