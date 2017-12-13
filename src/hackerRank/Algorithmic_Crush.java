package hackerRank;

import java.util.Scanner;

/**
 * Created by j_rus on 4/1/2017.
 */
public class Algorithmic_Crush {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
    int len = in.nextInt();
    int loopLen = in.nextInt();
    int [] nums = new int[len];
    for(int i = 0; i < loopLen; i++){
        int a = in.nextInt()-1;
        int b = in.nextInt()-1;
        int c = in.nextInt();
        for(int k = a; k<=b; k++){
            nums[k] = nums[k] + c;
        }

    }
    int result = nums[0];
    for (int i = 0; i < nums.length-2; i++) {
        if(nums[i] > result){
            result = nums[i];
        }
    }

            System.out.print(result);

}

/*
public static void main(String[] args) {
    int N, M, a, b;
    long k; // int k;
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    M = in.nextInt();
    long[] differenceArray = new long[N+1]; // int[] ...
    for (int i=0; i<M; i++)
    {
        in.nextLine();
        a = in.nextInt();
        b = in.nextInt();
        k = in.nextLong(); // in.nextInt();
        differenceArray[a] += k;
        if (b+1<=N)
            differenceArray [b+1] -= k;
    }

    long max = 0, addedDifference = 0; // int
    for (int i=1; i<=N; i++)
    {
        addedDifference = addedDifference + differenceArray[i];
        if (max < addedDifference)
            max = addedDifference;
    }
    System.out.println(max);
    in.close();

}
 */

}
