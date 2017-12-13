package Sandbox;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by j_rus on 4/29/2017.
 */
public class Sandbox12 {

    public static int maxsubArray(int [] array, int mod){
        int len = array.length;
        int sublen = 1;
        int maxSum = 0;
        int subSum = 0;
        int tempSum = -1;
        int intialEnd = 2;
        int start = 0;
        int end = intialEnd;

        while(len > 0){
            for (int i = 0; i < len; i++) {
                tempSum = 0;
                if(sublen == 1){
                    int[] copyArr = Arrays.copyOf(array,sublen);
                    copyArr[0] = array[i];
                    tempSum = copyArr[0] % mod;
                }else{
                    if(end <= array.length) {
                        int[] copyArr = Arrays.copyOfRange(array, start, end);
                        for (int j = 0; j < copyArr.length; j++) {
                            subSum += copyArr[j];
                        }
                        tempSum = subSum % mod;
                        subSum = 0;
                        start++;
                        end++;
                    }
                }

                if (tempSum > maxSum){
                    maxSum = tempSum;
                }
            }
            if(sublen != 1){
                start = 0;
                intialEnd ++;
                end = intialEnd;
            }
            sublen++;
            len--;
        }

        return maxSum;
    }

    public static void main(String [] args){
        //int [] arr = {3, 3, 9, 9, 5};
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int len = in.nextInt();
        int mod = in.nextInt();
        int [] arr = new int[len];
        for(int a0 = 0; a0 < len; a0++) {
            arr[a0] = in.nextInt();
        }
        maxsubArray(arr, mod);
    }
}
