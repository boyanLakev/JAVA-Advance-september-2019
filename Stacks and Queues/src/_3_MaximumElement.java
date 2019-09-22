import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class _3_MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxstack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] tokens = (reader.readLine().split(" "));
            int command=Integer.parseInt(tokens[0]);
            switch (command) {
                case 1:
                    int value=Integer.parseInt(tokens[1]);
                    stack.push(value);
                    if (value > max) {
                        maxstack.push(value);
                        max=value;
                    }


                    break;
                case 2:
                    if (stack.peek() == max) {
                        stack.pop();
                        maxstack.pop();
                        if(!maxstack.isEmpty())
                        {
                            max=maxstack.peek();
                        }else{
                            max=0;
                        }


                    }else{
                        stack.pop();

                    }

                    break;
                case 3:

                    sb.append(max).append(System.lineSeparator());



                    break;
            }
        }
        System.out.println(sb);
    }
}
