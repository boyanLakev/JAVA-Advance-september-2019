import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _5_FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] current = reader.readLine().split(", ");
            map.put(current[0], Integer.parseInt(current[1]));
        }
        String condition = reader.readLine();

        int age = Integer.parseInt(reader.readLine());
        String print=reader.readLine();
        BiPredicate<Integer, Integer> olderThan = (a, b) -> a >= b;
        BiPredicate<Integer, Integer> youngeThan = (a, b) -> a <= b;
        Consumer<Integer> printAge = (e) -> System.out.println(e);
        Consumer<String> printName = (e) -> System.out.println(e);
        BiConsumer<String,Integer> printNameAge=(k,v)-> System.out.println(k+" - "+v);
        map.entrySet().stream()
                .filter(e -> {
                    if (condition.equals("older")) {
                        return olderThan.test(e.getValue(), age);
                    } else {
                        return youngeThan.test(e.getValue(), age);
                    }
                })
                .forEach(e->{
                    if(print.equals("name")){
                        printName.accept(e.getKey());
                    }else if(print.equals("age")){
                        printAge.accept(e.getValue());
                    }else {
                        printNameAge.accept(e.getKey(),e.getValue());
                    }
                });

    }
}
