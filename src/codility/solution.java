package codility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class solution {

    private String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    public String solutionDays(String S, int K) {
        // write your code in Java SE 8
        int currentDay = 0;
        for (int i = 0; i < days.length; i++) {
            if(S.equals(days[i])){
                currentDay = i;
                break;
            }
        }

        for (int i = 0; i < K; i++) {
            if(currentDay == days.length-1){
                currentDay = 0;
            }else {
                currentDay++;
            }
        }

        return days[currentDay];
    }

   public static void main(String [] arg){
        solution sol = new solution();

        System.out.println(sol.solutionDays("Sat", 12));
   }
}
