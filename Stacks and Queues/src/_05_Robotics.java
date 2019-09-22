import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _05_Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] robotAll = reader.readLine().split(";");
        String[] robot = new String[robotAll.length];
        int[] workTime = new int[robotAll.length];

        for (int i = 0; i < robotAll.length; i++) {
            String[] string=robotAll[i].split("-");

            robot[i] = string[0];

            workTime[i] = Integer.parseInt(string[1]);

        }
        int[] start = Arrays.stream(reader.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int startTime = start[0] * 3600 + start[1] * 60 + start[2];
        ArrayDeque<String> detail = new ArrayDeque<>();
        while (true) {
            String line = reader.readLine();
            if ("End".equals(line)) {
                break;
            }
            detail.offer(line);
        }
        int[] freeWork = new int[robot.length];
        int time = startTime;
        StringBuilder sb = new StringBuilder();
        int min=Arrays.stream(freeWork).min().getAsInt();
        while (true) {
            time++;
            if (detail.isEmpty()){
                break;
            }
            String current = detail.poll();
            boolean freeElement = true;
            for (int i = 0; i < robot.length; i++) {
                if (min>time){
                    break;
                }
                if (freeWork[i] <= time) {
                    freeWork[i] = time + workTime[i];
                    sb.append(robot[i]).append(" - ").append(current);
                    int second = time % 60;
                    int minit = (time / 60) % 60;
                    int hour = (time / (60*60))%24 ;
                    String formatTime = String.format(" [%02d:%02d:%02d] %n", hour, minit, second);
                    sb.append(formatTime);
                    freeElement = false;
                    if (min>freeWork[i]){
                        min=freeWork[i];
                    }
                    break;
                }
            }

            if (freeElement) {
                detail.offer(current);
            }


        }
        System.out.println(sb);
    }
}
