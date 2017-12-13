package google;

/**
 * Created by j_rus on 9/30/2016.
 */
public class FibonacciWithMemoization {

    public static long fibArray[]=new long[60001];

    public static long fibonacci(long n){
        if(n <= 1 ){
            return n;
        }else if(fibArray[(int)n]!=0){
            return fibArray[(int)n];
        }else{
            fibArray[(int) n] = fibonacci(n-1)+fibonacci(n-2);
            return fibArray[(int) n];
        }
    }

    static  int climbingStairs(int n) {

        if( n == 1){
            return n;
        }

        if( n == 2){
            return n;
        }

        int[] mem = new int[n+1];

        mem[0] = 1;
        mem[1] = 2;

        for(int i=2; i <= n; i++){
            mem[i] = mem[i-1]+mem[i-2];
        }

        return mem[n];

    }

    static int houseRobber (int[] num){
        if(num==null || num.length == 0)
            return 0;

        int even = 0;
        int odd = 0;

        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                even += num[i];
                even = even > odd ? even : odd;
            } else {
                odd += num[i];
                odd = even > odd ? even : odd;
            }
        }

        return even > odd ? even : odd;
    }

    public static void main(String args[]){
        /*fibArray[0]=1;
        fibArray[1]=1;
        long preTime=System.currentTimeMillis();
        System.out.println("Value of 25th number in Fibonacci series->"+fibonacci(25));
        long postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
        */
        //climbingStairs(4);

        int houses[] = {1, 7, 9, 4};

        houseRobber(houses);

    }
}
