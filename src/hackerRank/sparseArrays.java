package hackerRank;

import java.util.Scanner;

/**
 * Created by j_rus on 3/31/2017.
 */
public class sparseArrays {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int num1 = in.nextInt();
        String [] words1 = new String[num1];
        for(int i =0; i<num1; i++){
            words1[i] = in.next();
        }
        int num2 = in.nextInt();
        String [] words2 = new String[num2];
        for(int i =0; i<num2; i++){
            words2[i] = in.next();
        }

        int [] results = new int[num2];
        int res_indx =0;
        for(String wd2 : words2){
            for (String wd1: words1 ) {
                if(wd2.equals(wd1)){
                    results[res_indx]++;
                }
            }
            res_indx++;
        }

        for (int i: results) {
            System.out.println(i);
        }
    }
}
