package Sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by j_rus on 4/26/2017.
 */
public class Sandbox11 {

    public static void array_game(int [] arr){
        int maxCrecSeq = 1;
        int lastMax = arr[0];
        for(int i=1;i<arr.length;i++) {
            if(arr[i]>lastMax) {
                maxCrecSeq++;
                lastMax=arr[i];
            }
        }
        if(maxCrecSeq%2==0) System.out.println("ANDY");
        else System.out.println("BOB");
    }

    public static void main(String arg[]){
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int [] arr = new int[n];
            for(int a1 = 0; a1 < n; a1++){
                arr[a1] = in.nextInt();
            }
            array_game(arr);
        }

        System.out.print(g);
    }
}
