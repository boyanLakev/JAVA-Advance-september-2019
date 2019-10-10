import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _2_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        Function<String,Integer> count= e->{
            List<String> list=Arrays.stream(e.split(", "))
                    .collect(Collectors.toList());
            return  list.size();
        };
        Function<String,Integer> sum=e->{
            int number= Arrays.stream(e.split(", "))
                    .mapToInt(Integer::parseInt)
                    .reduce(0,(a,b)-> a+b);
            return number;
        };
        System.out.println("Count = "+count.apply(input));
        System.out.println("Sum = "+sum.apply(input));
    }
}
