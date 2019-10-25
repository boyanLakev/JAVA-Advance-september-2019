import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hallCapacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        Deque<String> hallAllreservation = initilazStack(input, hallCapacity);

        Deque<String> halls = new ArrayDeque<>();
        Deque<Integer> currentHallReservation = new ArrayDeque<>();
        int currentHallcapacity = 0;
        while (!hallAllreservation.isEmpty()) {
            String currentElement = hallAllreservation.pop();
            if (Character.isDigit(currentElement.charAt(0))) {
                int reservation = Integer.parseInt(currentElement);
                if (currentHallcapacity + reservation > hallCapacity) {
                    printHall(halls,currentHallReservation);
                    currentHallcapacity=0;

                }
                if(halls.isEmpty()){
                    continue;
                }
                currentHallcapacity += reservation;
                currentHallReservation.add(reservation);
            } else {
                halls.add(currentElement);
            }
        }
    }

    private static void printHall(Deque<String> halls, Deque<Integer> currentHallReservation) {
        System.out.print(halls.poll()+" -> ");
        while (!currentHallReservation.isEmpty()){
            System.out.print(currentHallReservation.poll());

            if(!currentHallReservation.isEmpty())
                System.out.print(", ");
        }
        System.out.println();

    }

    private static Deque<String> initilazStack(String[] input, int hallCapacity) {
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }
        return stack;
    }

}
