import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> map = new HashMap<>();
        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            switch (tokens.length) {
                case 1:
                    BankAccount bankAccount = new BankAccount();
                    map.put(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n",bankAccount.getId());
                    break;
                case 2:
                    double rate=Double.parseDouble(tokens[1]);
                    BankAccount.setInterestRate(rate);
                    break;
                case 3:
                    int id = Integer.parseInt(tokens[1]);
                    if (!map.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        if ("Deposit".equals(tokens[0])) {
                                double amount = Double.parseDouble(tokens[2]);
                                map.get(id).deposit(amount);
                            System.out.printf("Deposited %.0f to ID%d%n",amount,id);

                        } else{
                            int year=Integer.parseInt(tokens[2]);

                            System.out.printf("%.2f%n",map.get(id).getInterest(year));

                        }
                    }
                    break;
            }
        }
    }
}
