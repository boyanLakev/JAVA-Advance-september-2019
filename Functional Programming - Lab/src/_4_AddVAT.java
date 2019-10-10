import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class _4_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] prices=scanner.nextLine().split(", ");
        UnaryOperator<Double> vat= d-> d*1.2;


        System.out.println("Prices with VAT:");
        Arrays.stream(prices)
                .mapToDouble(Double::parseDouble)
                .map(e-> vat.apply(e))
                .forEach(e -> System.out.printf("%.2f%n",e) );
    }
}
