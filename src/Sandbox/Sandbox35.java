package Sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sandbox35 {

    boolean containsCloseNums(int[] nums, int k) {

        Map<Integer, List<Integer>> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(numMap.containsKey(nums[i])){
                List<Integer> tempList = numMap.get(nums[i]);
                tempList.add(i);
                numMap.put(nums[i], tempList);
            }else{
                List<Integer> idxs = new ArrayList<>();
                idxs.add(i);
                numMap.put(nums[i], idxs);
            }
        }

        for (List<Integer> idxlist: numMap.values()) {

            if(idxlist.size() > 1){
                for (int i = 0; i < idxlist.size()-1 ; i++) {
                    int diff = Math.abs(idxlist.get(i) - idxlist.get(i+1));
                    if (diff <= k){
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static void main(String [] args){
        Sandbox35 sb35 = new Sandbox35();
        int [] nums = {99,99};
        int k = 2;
        sb35.containsCloseNums(nums, k);
    }

}
