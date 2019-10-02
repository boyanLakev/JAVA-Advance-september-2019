import java.util.*;

public class _11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        Map<String,Integer> timeMap=new TreeMap<>();
        Map<String, Set<String>> ipMap=new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line= scanner.nextLine().split("\\s+");
            String ip=line[0];
            String name=line[1];
            int time=Integer.parseInt(line[2]);
            if(!timeMap.containsKey(name)){
                timeMap.put(name,0);
            }
            timeMap.put(name,timeMap.get(name)+time);
            if(!ipMap.containsKey(name)){
                ipMap.put(name,new TreeSet<>());
            }
            ipMap.get(name).add(ip);

        }
        timeMap.entrySet().stream().forEach(e->{
            System.out.print(e.getKey()+": "+ e.getValue()+" [");
            System.out.print(String.join(", ",ipMap.get(e.getKey())));
            System.out.println("]");

        });


    }
}
