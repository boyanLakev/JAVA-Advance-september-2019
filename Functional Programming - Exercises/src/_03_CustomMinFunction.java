import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Function<int[],Integer> function=(a)-> Arrays.stream(a)
                .reduce(Integer.MAX_VALUE,(e1,e2)-> (e1<e2)? e1:e2);
        int[] number= Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int min=function.apply(number);
        System.out.println(min);

    }
}
