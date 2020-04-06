package dailycoding;

import java.util.*;

public class LongestSubArray {

    int pStart = 0, pEnd = 0, pCount = 0;

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

    public int [] largestModSub(int [] arr){
        int st = -1, end = 0, count = 0;
        int [] results = new int[arr.length];
        for (int i = 0; i < arr.length-1 ; i++) {
            if(mod(arr[i], arr[i+1])){
                count++;
                if(st == -1) {
                    st = i; end = i+1;
                }else{
                    end = i+1;
                }
            }else if(st >= 0 && count > pCount){
                Arrays.fill(results, 0);
                results = setSub(st, end, count, arr, results);
                st = -1; count =0;
            }
        }

        if(st >= 0 && count > pCount) {
            results = setSub(st, end, count, arr, results);
        }
        return results;
    }

    private int [] setSub(int st, int end, int count, int[] arr, int [] results){
        pStart = st; pEnd = end;
        pCount = count;
        return  Arrays.copyOfRange(arr, pStart, pEnd+1);
    }

    private boolean mod(int a, int b){
        return a%b == 0 || b%a == 0;
    }

    public static void main(String [] args){
        int [] arr = {1,2,3,5,7,9};

        LongestSubArray longestSubArray = new LongestSubArray();
        //System.out.println(longestSubArray.longestDistinctSubArray(arr));

        int [] arr2 = {1, 3, 6, 24};

        int [] res = longestSubArray.largestModSub(arr2);

        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]);
        };
    }
}
