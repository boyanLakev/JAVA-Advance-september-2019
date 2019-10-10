import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class _6_FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dimention= Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int start=dimention[0];
        int end=dimention[1];

        BiPredicate<String,Integer> predicate=(s,e)-> s.equals("odd")? e%2!=0:e%2==0;
        String predic=reader.readLine();
        for (int i = start; i <=end ; i++) {
            if(predicate.test(predic,i)){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
