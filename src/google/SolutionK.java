package google;

import java.util.Arrays;

/**
 * Created by j_rus on 11/17/2016.
 */
public class SolutionK {

    int smallestDifference(int [] A, int [] B){

        if(A.length == 0 || B.length == 0){
            return -1;
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int lowestDiff = -1;
        int indexA = 0;
        int indexB = 0;
        while(indexA <= A.length -1 && indexB <= B.length -1){

            int tempLowDiff = Math.abs(A[indexA] - B[indexB]);
            if(lowestDiff < 0 || tempLowDiff < lowestDiff){
                lowestDiff = tempLowDiff;
            }

            if(A[indexA] < B[indexB]){
                indexA++;
            }else{
                indexB++;
            }
        }
        return lowestDiff;
    }

    public static void main(String [] arg){
        SolutionK sk = new SolutionK();
        int [] A = {17,21,3,4,112};
        int [] B = {45,20,23,13,18};
        System.out.print(sk.smallestDifference(A, B));

    }
}
