import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _7_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        while (true) {
            String name = scanner.nextLine();
            if ("stop".equals(name)) {
                break;
            }
            String email = scanner.nextLine();
            map.put(name, email);

        }
        for (Map.Entry<String, String> en : map.entrySet()) {


            String domein = en.getValue().substring(en.getValue().lastIndexOf(".") + 1);
            if (domein.equals("us") || domein.equals("com") || domein.equals("uk")) {


            } else {
                System.out.println(en.getKey() + " -> " + en.getValue());
            }
        }


    }
}
