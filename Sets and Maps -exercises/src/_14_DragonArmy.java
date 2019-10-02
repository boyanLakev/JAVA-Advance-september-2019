import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _14_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] part = scanner.nextLine().split("\\s+");
            String type = part[0];
            if (!Character.isUpperCase(type.charAt(0))) {
                continue;
            }
            String dragon = part[1];
            if (!Character.isUpperCase(dragon.charAt(0))) {
                continue;
            }
            int damage = (part[2].equals("null")) ? 45 : Integer.parseInt(part[2]);
            int health = (part[3].equals("null")) ? 250 : Integer.parseInt(part[3]);
            int armor = (part[4].equals("null")) ? 10 : Integer.parseInt(part[4]);

            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }
            if (!dragons.get(type).containsKey(dragon)) {
                dragons.get(type).put(dragon, new int[3]);
            }
            dragons.get(type).get(dragon)[0] = damage;
            dragons.get(type).get(dragon)[1] = health;
            dragons.get(type).get(dragon)[2] = armor;


        }
        dragons.entrySet().stream()
                .forEach(e->{
                    double damageAvr=e.getValue().entrySet().stream()
                            .map(inE-> inE.getValue()[0])
                            .mapToInt(Integer::intValue)
                            .average()
                            .getAsDouble();
                    double healthAvr=e.getValue().entrySet().stream()
                            .map(inE-> inE.getValue()[1])
                            .mapToInt(Integer::intValue)
                            .average()
                            .getAsDouble();
                    double armorAvr=e.getValue().entrySet().stream()
                            .map(inE-> inE.getValue()[2])
                            .mapToInt(Integer::intValue)
                            .average()
                            .getAsDouble();
                    String avrDamStr=String.format("%.2f",damageAvr);
                    avrDamStr=avrDamStr.replace(",",".");
                    String avrHealthStr=String.format("%.2f",healthAvr);
                    avrHealthStr=avrHealthStr.replace(",",".");
                    String avrArmorStr=String.format("%.2f",armorAvr).replace(",",".");

                    System.out.printf("%s::(%s/%s/%s)%n",e.getKey(),avrDamStr,avrHealthStr,avrArmorStr);
                    e.getValue().entrySet().stream()
                            .forEach(f->
                                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n"
                                            ,f.getKey()
                                            ,f.getValue()[0]
                                            ,f.getValue()[1]
                                            ,f.getValue()[2]));




                });
    }

}
