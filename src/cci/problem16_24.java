package cci;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by j_rus on 1/29/2017.
 */
public class problem16_24 {

    public void pSums(int [] arr, int value ){
        HashSet<Integer> nums = new HashSet<>();
        int compliment = 0;
        for (int i = 0; i < arr.length ; i++) {
            compliment = value - arr[i];
            if(nums.contains(compliment) && !nums.contains(arr[i])){
                System.out.println(arr[i] + ","+compliment);
            }
            nums.add(arr[i]);
        }

    }

    public static void main(String [] arg){
         int [] arr = {12,8,9,10,1,6,3,6};
         int value = 9;
         problem16_24 obj = new problem16_24();
         obj.pSums(arr, value);

    }
}
