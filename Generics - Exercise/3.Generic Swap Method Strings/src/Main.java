import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<Box<String>> list=new ArrayList<>();
        while (n-->0){
            Box<String> box=new Box<>(scanner.nextLine());
            list.add(box);

        }
        int first=scanner.nextInt();
        int  second=scanner.nextInt();
        swap(list,first,second);
        list.forEach(System.out::println);

    }
    private static<T> void swap(List<Box<T>> list, int first, int second){
        Collections.swap(list,first,second);
    }

}
