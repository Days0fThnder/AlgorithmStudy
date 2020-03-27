package dailycoding;

import java.util.HashSet;
import java.util.Set;

public class LongestSubArray {

    public int longestDistinctSubArray(int [] arr){

        if(arr.length == 1){
            return 1;
        }

        if(arr.length == 0){
            return 0;
        }
        Set<Integer> seen = new HashSet<>();
        int longest = 0, curr = 0;

        for (int num : arr) {
            if (seen.contains(num)) {
                seen.clear();
                if (curr > longest) {
                    longest = curr;
                }
                curr = 1;
            } else {
                curr++;
            }
            seen.add(num);
        }

        return curr > longest ? curr : longest;
    }

    public static void main(String [] args){
        int [] arr = {1,2,3,5,7,9};

        LongestSubArray longestSubArray = new LongestSubArray();
        System.out.println(longestSubArray.longestDistinctSubArray(arr));
    }
}
