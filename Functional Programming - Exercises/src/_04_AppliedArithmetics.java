import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list= Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<Integer,Integer> add= e-> e+1;
        Function<Integer,Integer> multiply= e-> e*2;
        Function<Integer,Integer> subtract= e-> e-1;
        Consumer<Integer> print= a-> System.out.print(a+" ");
        while(true){
            String line=reader.readLine();
            if("end".equalsIgnoreCase(line)){
                break;
            }
            if("add".equalsIgnoreCase(line)){
                list= list.stream().map(add).collect(Collectors.toList());
            }else if("multiply".equalsIgnoreCase(line)){
                list= list.stream().map(multiply).collect(Collectors.toList());

            }else if("subtract".equalsIgnoreCase(line)){
                list= list.stream().map(subtract).collect(Collectors.toList());

            }else {
                list.forEach(print);
                System.out.println();
            }
        }

    }
}
