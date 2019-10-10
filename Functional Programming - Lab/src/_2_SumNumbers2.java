import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _2_SumNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] string=scanner.nextLine().split(", ");
        Function<String,Integer> parse=e-> Integer.parseInt(e);
        long count=Arrays.stream(string).count();
        List<Integer> number=Arrays.stream(string)
                .map(parse)
                .collect(Collectors.toList());
        int sum=number.stream().reduce(0,(a,b)->a+b);
        System.out.println("Count = "+count);
        System.out.println("Sum = "+sum);


    }
}
