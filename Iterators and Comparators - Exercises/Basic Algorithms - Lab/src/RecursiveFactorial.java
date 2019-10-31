import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        long facN=factoriel(n);
        System.out.println(facN);
    }

    private static long factoriel(int n) {
        if(n==0){
            return 1;
        }
        return factoriel(n-1)*n;
    }
}
