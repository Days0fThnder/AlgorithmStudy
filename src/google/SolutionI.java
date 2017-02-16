package google;

import java.util.Scanner;

/**
 * Created by j_rus on 11/3/2016.
 */
public class SolutionI {
    public static int bubbleSort(int [] arr){
        boolean isSorted = false;
        int numberOfSwaps = 0;
        while(!isSorted){
            isSorted = true;
            int lastSorted = arr.length -1;
            for(int i = 0; i < lastSorted; i++){
                if(arr[i] > arr[i+1]){
                    swap(i, i+1, arr);
                    isSorted = false;
                    numberOfSwaps++;
                }
            }
        }
        return numberOfSwaps;
    }

    private static void swap(int a, int b, int [] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    private static void swap(int a, int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.print(a + " "+b);
    }



    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int numberOfSwaps = bubbleSort(a);
        System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);*/
        swap(5,7);

    }
}
