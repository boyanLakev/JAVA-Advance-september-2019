import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class _04_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] control = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] data = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < control[0]; i++) {
            queue.offer(data[i]);
        }
        for (int i = 0; i < control[1]; i++) {
            queue.poll();
        }
        if (queue.contains(control[2])) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                int min = queue.stream().mapToInt(Integer::intValue).min().getAsInt();
                System.out.println(min);
            }
        }
    }

}
