package Sandbox;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by j_rus on 6/22/2017.
 */
public class Sandbox22 {

    static int firstDuplicate(int[] a) {

        Set<Integer> a_set = new HashSet<>();

        for (int i : a) {
            if(a_set.contains(i)){
                return i;
            }else{
                a_set.add(i);
            }
        }

        return -1;
    }

    int firstDuplicate2(int[] a) {

        int lowestIdx = -1;
        int start = 0;
        int end = a.length-1;

        if(a.length == 3){
            if(a[0] == a[1]){
                return lowestIdx = a[0];
            }else if(a[0] == a[2]){
                return lowestIdx = a[0];
            }else if(a[1] == a[2]){
                return lowestIdx = a[1];
            }
        }

        while(start < end){
            if(a[start] == a[end]){
                lowestIdx = a[end];
                start++;
                end--;
            }else{
                end--;
            }
        }

        return lowestIdx;
    }


    public static void main(String [] args){
       int[] a = {2, 3, 3, 1, 5, 2};
       firstDuplicate(a);
    }

}
