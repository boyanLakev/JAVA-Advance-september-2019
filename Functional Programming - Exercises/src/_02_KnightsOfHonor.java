import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> consumer= e-> System.out.println("Sir "+e);
        Arrays.stream(reader.readLine().split(" "))
                .forEach(consumer);
    }
}
