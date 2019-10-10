import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _3_CountUppercaseWords {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        String[] words=scanner.nextLine().split("\\s+");
        Predicate<String> upWord= e-> Character.isUpperCase(e.charAt(0));
        List<String> word= Arrays.stream(words).filter(upWord).collect(Collectors.toList());
        System.out.println(word.size());
        word.stream().forEach(e-> System.out.println(e));
    }
}
