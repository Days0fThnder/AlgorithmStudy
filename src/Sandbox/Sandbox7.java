package Sandbox;

import java.util.HashSet;
import java.util.*;

/**
 * Created by j_rus on 4/8/2017.
 */
public class Sandbox7 {

    static int[] removes(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int currentNum = arr[0];
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(currentNum != arr[i]) {
                currentNum = arr[i];
                if(count < 3){
                    results.add(arr[i-1]);
                    count = 1;
                }
                if(count >= 3){
                    count = 1;
                }
            }else if(currentNum == arr[i]){
                count++;
            }


        }
        int [] resArr = new int [results.size()];
        for (int i = 0; i < results.size(); i++) {
            resArr[i] = results.get(i);
        }

        return resArr;

    }

    public  static void main(String [] arg){
        int [] arr = {1,2, 1, 2 ,2,
                2,
                3,
                4,
                4,
                5,
                5,
                5,
                5,
                5};

        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(21, "twenty one");
        numbers.put(22, "twenty two");
        numbers.put(23, "twenty three");
        numbers.put(24, "twenty four");
        numbers.put(25, "twenty five");
        numbers.put(26, "twenty six");
        numbers.put(27, "twenty seven");
        numbers.put(28, "twenty eight");
        numbers.put(29, "twenty nine");

        numbers.put(31, "thirty one");
        numbers.put(32, "thirty two");
        numbers.put(33, "thirty three");
        numbers.put(34, "thirty four");
        numbers.put(35, "thirty five");
        numbers.put(36, "thirty six");
        numbers.put(37, "thirty seven");
        numbers.put(38, "thirty eight");
        numbers.put(39, "thirty nine");

        numbers.put(41, "forty one");
        numbers.put(42, "forty two");
        numbers.put(43, "forty three");
        numbers.put(44, "forty four");
        numbers.put(39, "thirty nine");
        int [] res = removes(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }

    }
}
