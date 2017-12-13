package walletHub;

import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;

public class ComplementaryPairs {

    /**
     * This method returns an array with the two index values of the complementary numbers.
     * If there is no complementary pair then the method returns a pair of -1 index values.
     * This method assumes there is only one pair of complementary numbers of k
     * The time complexity of this method is O(n) since we have to look at very number in the array
     * The space complexity is O(n) as well since we have to store the complementary numbers in a set.
     * This method sacrifices memory for speed by using a set to store complementary values. We can do this
     * since memory is cheap where time is not. If we didn't use a set then the time complexity might have been
     * O(n^2) which is very inefficient for large inputs.
     * */
    int [] complementary(int [] arr, int k){
        Set<Integer> kset = new HashSet<>();
        int [] results = {-1, -1};
        int rIdx = 0;
        for (int i = 0; i < arr.length ; i++) {
            kset.add(k - arr[i]);
        }

        for (int i = 0; i < arr.length ; i++) {
            if(kset.contains(arr[i])){
                if(rIdx < 2){
                    results[rIdx] = i;
                    rIdx++;
                }
            }
        }

        return results;
    }
}
