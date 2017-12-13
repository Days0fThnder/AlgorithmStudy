package Sandbox;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class solution {

    public int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);
        Set<Integer> numSet = new TreeSet<>();
        int count = 1;
        int[] result = new int[2];
        int[] perfectClone = new int[nums.length];
        for (int i = 0; i < nums.length ; i++) {
            if(!numSet.contains(nums[i])){
                numSet.add(nums[i]);
            }else{
                result[0] = nums[i];
            }

            perfectClone[i] = count++;
        }

        for (int i = 0; i < perfectClone.length ; i++) {
            if(!numSet.contains(perfectClone[i])){
                result[1] = perfectClone[i];
            }
        }

        return result;

    }

    public int findLongestChain(int[][] pairs) {


        int counter = 1;
        for (int irow = 0; irow < pairs.length ; irow++) {
            int tempCounter = 0;
            for (int krow = 0; krow <pairs.length ; krow++) {
                if (irow != krow) {
                    if (pairs[irow][1] < pairs[krow][0]) {
                        tempCounter++;
                    }
                }

                if (tempCounter > counter) {
                    counter = tempCounter;
                } else if (tempCounter == counter) {
                    counter += tempCounter;
                }
            }
        }


        return counter;

    }

    public static void main(String [] arg){
        solution sb = new solution();
        /*int[] nums = {1,2,4,4};
        sb.findErrorNums(nums);
        int[][] pairs = {{3,4}, {2,3}, {1,2}};
        int [][] pairs2 = {{1,2}, {2,3}, {3,4}};
        sb.findLongestChain(pairs2);*/
        int test = 42 - 2;
        System.out.print(test);
    }
}
