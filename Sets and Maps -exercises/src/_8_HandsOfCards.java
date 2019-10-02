import java.util.*;

public class _8_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> player=new LinkedHashMap<>();
        while (true){
            String line=scanner.nextLine();
            if ("JOKER".equals(line)){
                break;
            }
            String name=line.split(": ")[0];
            String[] card=line.split(": ")[1].split(", ");
            if (!player.containsKey(name)){
                player.put(name,new HashSet<>());
            }
            for (int i = 0; i <card.length ; i++) {
                player.get(name).add(card[i]);
            }

        }
        Map<String,Integer> playerValue=new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : player.entrySet()) {
            int sum=0;
            for (String s : entry.getValue()) {
                sum+= convertValue(s);
            }
            playerValue.put(entry.getKey(),sum);

        }
        playerValue.forEach((s, i) -> System.out.println(s+": "+i) );


    }

    private static int convertValue(String s) {
        String first;
        String second;
        if (s.length()>2){
            first="10";
            second=s.substring(2).toUpperCase();

        }else{
            first=s.substring(0,1).toUpperCase();
            second=s.substring(1).toUpperCase();
        }
        HashMap<String,Integer> card=new HashMap<>();

        card.put("2",2);
        card.put("3",3);
        card.put("4",4);
        card.put("5",5);
        card.put("6",6);
        card.put("7",7);
        card.put("8",8);
        card.put("9",9);
        card.put("10",10);
        card.put("J",11);
        card.put("Q",12);
        card.put("K",13);
        card.put("A",14);
        Map<String,Integer> power=new HashMap<>();
        //S -> 4, H-> 3, D -> 2, C -> 1
        power.put("S",4);
        power.put("H",3);
        power.put("D",2);
        power.put("C",1);
        return power.get(second)*card.get(first);
    }
}
