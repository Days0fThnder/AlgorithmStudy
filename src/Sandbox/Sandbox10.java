package Sandbox;

import java.util.*;

/**
 * Created by j_rus on 4/24/2017.
 */
public class Sandbox10 {

    public static void simliarPair(int[] A, int[] B){
        if((A == null || A.length == 0) || (B == null || B.length == 0)){
            return;
        }
        Map<Integer, Integer> freqA = new HashMap<>();
        Map<Integer, Integer> freqB = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < B.length ; i++) {
            if(freqB.containsKey(B[i])){
                freqB.put(B[i], freqB.get(B[i])+1);
            }else {
                freqB.put(B[i], 1);
            }
        }

        for (int i = 0; i < A.length ; i++) {
            if(freqA.containsKey(A[i])){
                freqA.put(A[i], freqA.get(A[i])+1);
            }else {
                freqA.put(A[i], 1);
            }
        }

        for (Integer numKey: freqB.keySet()) {
                int f = freqA.get(numKey);
                int j = freqB.get(numKey);
                if (f != j) {
                    results.add(numKey);
                }
        }


        Collections.sort(results);

        for (int i = 0; i < results.size() ; i++) {
            if(i == results.size()-1){
                System.out.print(results.get(i));
            }else{
                System.out.print(results.get(i)+" ");
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] A = new int [n];
        for (int i = 0; i < n ; i++) {
            A[i] = in.nextInt();
        }
        int m = in.nextInt();
        int [] B = new int[m];
        for (int i = 0; i < m ; i++) {
            B[i] = in.nextInt();
        }
        simliarPair(A, B);
    }
}
