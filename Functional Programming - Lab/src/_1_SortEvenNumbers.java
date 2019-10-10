import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class _1_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = reader.readLine().split(", ");

        List<String> number = Arrays.stream(array)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(e->String.valueOf(e))
                .collect(Collectors.toList());
        if (number.size() > 0) {
            System.out.println(String.join(", ", number));
            List<String> sort=number.stream().map(e ->Integer.parseInt(e))
                    .sorted()
                    .map(e-> String.valueOf(e))
                    .collect(Collectors.toList());
            System.out.println(String.join(", ",  sort));
        }
    }
}
