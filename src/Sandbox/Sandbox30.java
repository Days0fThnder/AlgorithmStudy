package Sandbox;

import java.util.ArrayList;
import java.util.List;

public class Sandbox30 {

    List<List<Integer>> climbs = new ArrayList<>();
    int idx = 0;

    public int countWays(int n) {
        int ways[] = new int[n + 1];
        int i;
        ways[0] = 0;
        ways[1] = 1;

        for (i = 2; i < ways.length; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];

    }

    int[][] climbingStaircase(int n, int k) {
        int ways = countWays(n + 1);
        int stepsClimbed = 0;

        waysToTop(stepsClimbed, n, k, new ArrayList<>());
        int[][] test = new int[ways][5];
        return test;
    }


    private void waysToTop(int stepsClimbed, int n, int k, ArrayList<Integer> climbSorFar ) {
        if (stepsClimbed == n ){
            System.out.println(climbSorFar);

        }else if (stepsClimbed > n) {
            return;
        }

        for (int i = 1; i <= k; i++) {
            climbSorFar.add(i);
            waysToTop(stepsClimbed + i, n, k, climbSorFar);
            climbSorFar.remove(climbSorFar.size() - 1);
        }

        return;

    }

    public static void main(String[] arg) {
        Sandbox30 sb = new Sandbox30();
        System.out.println(sb.climbingStaircase(4, 2));
    }
}
