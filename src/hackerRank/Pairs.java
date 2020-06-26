package hackerRank;

import java.util.HashMap;
import java.util.Map;

public class Pairs {

    static int pairs(int k, int[] arr) {
        Map<Integer, Integer> pairMap = new HashMap<>();
        int pairCount = 0;
        for(int i = 0; i < arr.length; i++){
            pairMap.put(arr[i], Math.abs(arr[i] - k));
        }

        for(Integer in : pairMap.keySet()){
            if((Math.abs(in - pairMap.get(in)) == k) &&
                    pairMap.containsKey(pairMap.get(in))){
                pairCount++;
            }
        }

        return pairCount;

    }

    public static void main(String[] args){
        int [] arr = {1, 5, 3, 4, 2};
        Pairs.pairs(2 , arr);
    }
}
