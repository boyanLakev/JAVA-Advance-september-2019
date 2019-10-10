import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(reader.readLine());
        List<String> names= Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> predicate=e-> e.length()<=n;
        names.stream().filter(predicate).forEach(System.out::println);


    }
}
