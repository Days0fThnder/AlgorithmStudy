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

    public static void main(String args[]){
        fibArray[0]=1;
        fibArray[1]=1;
        long preTime=System.currentTimeMillis();
        System.out.println("Value of 25th number in Fibonacci series->"+fibonacci(25));
        long postTime=System.currentTimeMillis();
        System.out.println("Time taken to compute in milliseconds->"+(postTime-preTime));
    }
}
