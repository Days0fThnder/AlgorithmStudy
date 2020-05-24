package dailycoding;

import dailycoding.minIntervals.Interval;

public class MaximumWeightPath {


    public static int MaxWeightPath(int[][] tri){

        int first = tri[0][0];
        int max = first;
        int curr = Integer.MIN_VALUE;

        for (int i = 1; i < tri.length ; i++) {
            for(int j = 0; j < tri[i].length; j++){
                curr = Math.max(curr, tri[i][j]);
            }
            max += curr;
            curr = Integer.MIN_VALUE;
        }

        return max;
    }

    public static void main(String [] args) {
        int a[][] = {{1},
                {2, 3},
                {1, 5, 1}
        };

       System.out.println( MaximumWeightPath.MaxWeightPath(a));
    }
}
