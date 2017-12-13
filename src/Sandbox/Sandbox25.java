package Sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by j_rus on 7/2/2017.
 */
public class Sandbox25 {


    static String[][] groupingDishes(String[][] dishes) {

        TreeMap<String, Integer> ingFreq = new TreeMap<>();
        List<List<String>> group = new ArrayList<>();

        int idx = 1;
        int groupIdx = 0;

        for (int row = 0; row < dishes.length ; row++) {
            for (int col = 1; col < dishes[row].length ; col++) {
                if ( ingFreq.containsKey(dishes[row][col])){
                    ingFreq.put(dishes[row][col], ingFreq.get(dishes[row][col])+ 1);
                }else{
                    ingFreq.put(dishes[row][col], 1);
                }
            }
        }

       for (String ing: ingFreq.keySet()) {
           if (ingFreq.get(ing) > 1) {
               System.out.print("Yes");
               List<String> results = new ArrayList<>();


               for (int row = 0; row < dishes.length; row++) {
                   for (int col = 1; col < dishes[row].length; col++) {
                       if (dishes[row][col].equals(ing)) {
                           results.add(dishes[row][0]);
                           idx++;
                       }
                   }
               }
               Collections.sort(results);
               results.add(0, ing);
               group.add(groupIdx, results);
               groupIdx++;
               idx = 1;
           }
       }

       String[][] array = new String[group.size()][];
       String[] blankArray = new String[0];
       for(int i=0; i < group.size(); i++) {
           array[i] = group.get(i).toArray(blankArray);
       }

        return array;
    }

    public static void main(String[]arg){

        String [][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        groupingDishes(dishes);

    }
}
