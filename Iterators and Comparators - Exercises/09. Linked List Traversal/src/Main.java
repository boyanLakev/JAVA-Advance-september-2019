import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkList linkList=new LinkList();
        int count = Integer.parseInt(scanner.nextLine());
        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if(tokens[0].equals("Add")){
                linkList.addLast(Integer.parseInt(tokens[1]));
            }
            if(tokens[0].equals("Remove")){
                linkList.removeLast(Integer.parseInt(tokens[1]));
            }



        }
        System.out.println(linkList.size());
        for (Integer integer : linkList) {
            System.out.print(integer+ " ");
        }

    }
}
