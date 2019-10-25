import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidsArray=ReadIntegerArrays(scanner);
        int[] physictArray=ReadIntegerArrays(scanner);

        ArrayDeque<Integer> liquids=ParseQueue(liquidsArray);
        ArrayDeque<Integer> physics=ParseStack(physictArray);

        Map<String,Integer> matterMap=new TreeMap<>();
        matterMap.put("Glass",0);
        matterMap.put("Aluminium",0);
        matterMap.put("Lithium",0);
        matterMap.put("Carbon fiber",0);

        while (!(liquids.isEmpty() ||physics.isEmpty())){
            int currentLiquid=liquids.poll();
            int currentPhysics=physics.pop();

            int advanceMaterialSum=currentLiquid+currentPhysics;

            String material=getMaterial(advanceMaterialSum);


            if(material==null){
                physics.push(currentPhysics+3);

            }else {
                matterMap.put(material,matterMap.get(material)+1);
            }

        }
        if (matterMap.entrySet().stream().allMatch(e-> e.getValue()>0)){
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        String liquidRes="Liquids left: ";
        if(liquids.isEmpty()){
            liquidRes+="none";
        }else {
            StringBuilder sb=new StringBuilder();
            while (!liquids.isEmpty()){
                sb.append(liquids.poll());
                if (!liquids.isEmpty()){
                    sb.append(", ");
                }
            }
            liquidRes+=sb.toString();

        }
        System.out.println(liquidRes);

        String physicsRes="Physical items left: ";
        if(physics.isEmpty()){
            physicsRes+="none";
        }else {
            StringBuilder sb=new StringBuilder();
            while (!physics.isEmpty()){
                sb.append(physics.pop());
                if (!physics.isEmpty()){
                    sb.append(", ");
                }

            }
            physicsRes+=sb.toString();

        }
        System.out.println(physicsRes);

        matterMap.forEach((s,i)-> System.out.println(s+": "+i));

    }

    private static String getMaterial(int advanceMaterialSum) {
        String material=null;

        switch (advanceMaterialSum){
            case 25:
                material="Glass";
                break;
            case 50:
                material="Aluminium";
                break;
            case 75:
                material="Lithium";
                break;
            case 100:
                material="Carbon fiber";
                break;
        }

        return material;
    }

    private static int[] ReadIntegerArrays(Scanner scanner) {
        int[] array= Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e->Integer.parseInt(e))
                .toArray();
        return array;
    }

    private static ArrayDeque<Integer> ParseStack(int[] inputArray) {
        ArrayDeque stack=new ArrayDeque();
        for (int element : inputArray) {
            stack.push(element);
        }
        return stack;
    }

    private static ArrayDeque<Integer> ParseQueue(int[] liquidsArray) {
        ArrayDeque queue=new ArrayDeque();
        for (int element : liquidsArray) {
            queue.offer(element);
        }
        return queue;
    }
}
