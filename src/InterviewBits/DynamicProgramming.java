package InterviewBits;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {

    public int longestSubsequenceLength(final List<Integer> A) {

        int max = 0;
        int [] inc = new int[A.size()];
        int [] dec = new int[A.size()];
        int incLimit = -1;
        int decLimit = -1;

        for (int i = 0; i < A.size() ; i++) {
            if (i == 0){
                inc[i] = A.get(i);
                incLimit++;
            }else if (inc[incLimit] < A.get(i)){
                inc[incLimit+1] = A.get(i);
                incLimit++;
            }else{
                continue;
            }
        }

        for (int i = 0; i < A.size() ; i++) {
            if(i == 0){
                dec[i] = A.get(i);
                decLimit++;
            }else if(dec[decLimit] < A.get(i)){
                dec[decLimit] = A.get(i);
            }else if(dec[decLimit] > A.get(i)){
                dec[decLimit+1] = A.get(i);
                decLimit++;
            }else{
                continue;
            }
        }
        for (int i = 0; i < A.size() ; i++) {
            max = Math.max(max, dec[i]+inc[i] -1);
        }
        
        return max;
    }


    static int lis(int arr[],int n)
    {
        int lis[] = new int[n];
        int i,j,max = 0;

          /* Initialize LIS values for all indexes */
        for ( i = 0; i < n; i++ )
            lis[i] = 1;

           /* Compute optimized LIS values in bottom up manner */
        for ( i = 1; i < n; i++ )
            for ( j = 0; j < i; j++ )
                if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

           /* Pick maximum of all LIS values */
        for ( i = 0; i < n; i++ )
            if ( max < lis[i] )
                max = lis[i];

        return max;
    }

    public int numDecodings(String a) {
        if(a.length() == 0){
            return 0;
        }

        return ways(a, a.length()-1);
    }

    private int ways(String str, int end) {
        if (end < 0)
            return 1;

        int count = 0;

        if (str.charAt(end) > '0')
            count = ways(str,end-1);

        if (isValid(str,end)) {
            count = count + ways(str,end-2);
        }

        return count;
    }

    private boolean isValid(String str, int index){
        if (index > 0 && (str.charAt(index-1) == '1' || str.charAt(index-1) == '2' && str.charAt(index) < '7') )
            return true;

        return false;
    }

    public int minDistance(String a, String b) {
        // here row is size(not index) of elements of "String a" included
        // and col is size(not index) of elements of "String b" includuded
        int[][] dp = new int[a.length()+1][b.length()+1];

        // first row
        for (int col = 0; col <= b.length(); col++) {
            dp[0][col] = col;
        }

        // first col
        for (int row = 0; row <= a.length(); row++) {
            dp[row][0] = row;
        }

        // remaining
        for (int row = 1; row <= a.length(); row++) {
            for (int col = 1; col <= b.length(); col++) {
                if (a.charAt(row-1) == b.charAt(col-1)) {
                    dp[row][col] = dp[row-1][col-1];
                } else {
                    dp[row][col] = 1 + Math.min( dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1]));
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String [] arg){
        DynamicProgramming dp = new DynamicProgramming();
        String a = "attbt";
        String b = "abc";
        System.out.println(dp.minDistance(a, b));
    }
}
