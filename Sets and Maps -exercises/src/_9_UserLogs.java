import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _9_UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String,Integer>> map=new TreeMap<>();
        while(true){
            String line=scanner.nextLine();
            if ("end".equals(line)){
                break;
            }
            String name=line.substring(line.lastIndexOf("=")+1);
            String ip=line.substring(3,line.indexOf(" "));
            if (!map.containsKey(name)){
                map.put(name,new LinkedHashMap<String, Integer>());
            }
            if (!map.get(name).containsKey(ip)){
                map.get(name).put(ip,1);
            }else {
                map.get(name).put(ip, map.get(name).get(ip) + 1);
            }
        }
        //print
        map.forEach((k,v)->{
            System.out.println(k+":");
            int[] count=new int[1];
            count[0]=v.size()-1;
            v.forEach((key,val)->{

                System.out.print(key+" => "+val);
                System.out.print((count[0]>0)?", ":".");
                count[0]--;
            });
            System.out.println();
        });

    }
}
