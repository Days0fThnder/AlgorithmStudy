package Sandbox;


import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by j_rus on 6/28/2017.
 */
public class Sandbox24 {

    static String[] composeRanges(int[] nums) {
        if(nums.length == 0){
            return new String[0];
        }

        if(nums.length == 1){
            String[] stockArr = new String[1];
            stockArr[0] = ""+nums[0];
            return stockArr;
        }

        int i = 0;
        int len = nums.length;
        boolean newRange = true;
        int current = 0;
        String range = new String();
        List<String> results = new ArrayList<>();

        while (i < len-1){
            if(i == 0 || newRange){
                range = new String();
                range += nums[i];
                current = nums[i];
                newRange = false;

            }

            if((nums[i] + 1) != nums[i+1]){
                if(current != nums[i]) {
                    range += "->" + nums[i];
                }
                newRange = true;
                results.add(range);
            }else if((nums[i] +1) == nums[i+1] && nums[i+1] == nums[len-1]){
                range += "->"+nums[i+1];
                results.add(range);
            }

            if((nums[i+1]) == nums[len-1] && newRange){
                String lastRange = ""+nums[i+1];
                results.add(lastRange);
            }

            i++;
        }

        String[] stockArr = new String[results.size()];
        stockArr = results.toArray(stockArr);

        return stockArr;
    }

    public static void main(String arg []){
       int [] nums = {-1, 0, 1, 2, 6, 7, 9};
        composeRanges(nums);
    }
}
