import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer
                .parseInt(reader.readLine());
        List<Box<Double>> list=new ArrayList<>();
        while(n-->0){
            list.add(new Box<>(Double.parseDouble(reader.readLine())));

        }
        Box<Double > box=new Box<>(Double.parseDouble(reader.readLine()));
        System.out.println(fineAllFilter(list,box));

    }

    private static<T extends Comparable> int fineAllFilter(List<Box<Double>> list, Box<Double> box) {
        return  (int) list.stream().filter(e-> 0<e.getElement().compareTo(box.getElement())).count();

    }
}
