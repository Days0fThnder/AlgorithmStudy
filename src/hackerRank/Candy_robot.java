package hackerRank;

import java.util.Scanner;

/**
 * Created by j_rus on 3/15/2017.
 */
public class Candy_robot {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] c = new int[t];
        for(int c_i=0; c_i < t; c_i++){
            c[c_i] = in.nextInt();
        }
        // your code goes here
        int total_added = 0;
        int limit = n;
        for (int i = 0; i <= c.length-1 ; i++) {
            n = Math.abs(n - c[i]);
            if(n < 5 && i < c.length-1){
               total_added += limit - n;
               n = limit;
            }
        }

        System.out.println(total_added);
    }
}
