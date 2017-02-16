package projectEuler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_rus on 1/21/2017.
 */
public class problem2 {

    public static ArrayList<Integer> fibList(int limit){

        ArrayList<Integer> results = new ArrayList<>();
        int start = 1;
        results.trimToSize();

        while(fib(start) < limit){
            if(fib(start) <= limit) {
                results.add(fib(start));
            }else{
                fib(start);
            }
            start++;
            results.trimToSize();
        }

        return results;
    }

    public static Integer fib( Integer n){
        if(n <= 1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String [] arg){
        ArrayList<Integer> results = fibList(4000000);
        int index = 2;
        Integer sum =0;
        for (Integer num: results) {
            if(num%2 == 0){
                sum = sum.intValue() + num.intValue();
            }
        }
        System.out.println(sum);
            //if()
    }
}
