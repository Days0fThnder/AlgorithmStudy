package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by j_rus on 10/18/2016.
 */
public class Test {

    public static int findDigits(int n){
        int numOfDigits = 0;
        int orginalNum = n;
        while(n > 0){
            int digit = n%10;
            if(digit != 0 && orginalNum%digit == 0){
                numOfDigits++;
            }
            n = n/10;
        }
        return numOfDigits;
    }

    public static void randomSuffle(int arr []){
        Random random = new Random();
        for (int i = 0; i < arr.length ; i++) {
            int randomIndex = random.nextInt(arr.length);
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }

    public static void isFib(Long n){
            if(isPerfectSquare(5*n*n + 4) ||
                    isPerfectSquare(5*n*n - 4)){
                System.out.println("IsFibo");
            }else {
                System.out.println("IsNotFibo");
            }
    }
    private static boolean isPerfectSquare( Long n){
        double s = Math.sqrt(n);
        return( s*s == n);
    }

    public static int numOfSquares(int start, int end){

        if(start > end){
            return -1;
        }
        int squareCount =
                (int)Math.floor(Math.sqrt(end)) - (int)Math.ceil(Math.sqrt(start)) + 1;
        return squareCount;
    }

    private static boolean hasPerfectSqRoot(int i) {
        double sqr = Math.sqrt(i);
        double frac = sqr - (long)sqr;
        return(frac == 0.0);
    }

    private static int multiply(int numA, int numB){
        if(numB == 0){
            return 0;
        }else{

            return numA + multiply(numA, numB - 1);
        }
    }

    private static Long multiplyMem (Long numA, Long numB){
        return  multiply(numA, numB, new Long[numB.intValue() + 1]);
    }

    private static Long multiply(Long numA, Long numB, Long[] arr) {
        if(numB == 0){
            return 0L;
        }
        arr = new Long[numB.intValue() +1 ];
        if(arr[numB.intValue()] != null){
            return arr[numB.intValue()];
        }else{
            arr[numB.intValue()] = numA + multiply(numA, numB-1, arr);
            return arr[numB.intValue()];
        }
    }

    private static long candySupply(long n){
        long result = 0;
        if (n <= 0){
            return result;
        }
        for (long i = 1; i < n ; i++) {
            Long firstVal = n - i;
            Long tempRes = i * firstVal;
            if(tempRes > result){
                result = tempRes;
            }else if(tempRes == result){
                break;
            }
        }

        return result;
    }

    private static int divide(int n){
        return n/2;
    }

    public static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n-1) + fibonacci(n-2);
    }

    private static void printArray(int start, int end, int [] arr){
        if(end >= start){
            System.out.println(arr[start]);
            printArray(start + 1, end, arr);
        }
    }

    private static int largestSequence(int [] arr){
        return largestSequence(arr, 0, arr.length -1);
    }

    private static int largestSequence(int [] arr, int low, int high){
        int max_sum = arr[low];
        int temp_sum = 0;

        while (low <= high-1){
            if(arr[low] + arr[low + 1] < 0){
                if(low < high -1){
                    low =+2;
                    temp_sum = arr[low];
                }else{
                    low++;
                }
            }else if(arr[low] + arr[low+1] > 0){
                temp_sum += arr[low +1];
                low++;
            }
        }

        if(temp_sum > max_sum){
            return temp_sum;
        }else{
            return max_sum;
        }
    }

    public static int stock_price(int [] stocks){
        if(stocks.length < 2){
            throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
        }
        int min_price =  stocks[0];
        int max_profit = stocks[1] - stocks[0];

        for (int i = 1 ; i < stocks.length ; i++) {
            int current_price = stocks[i];
            int potential_profit = current_price - min_price;

            max_profit = Math.max(max_profit, potential_profit);

            min_price = Math.min(min_price, current_price);

        }


        return max_profit;
    }

    public static Map<Integer, Integer> pairOfSum (int [] arr, int sum){
        if(arr.length < 2){
            throw new IllegalArgumentException("array must have at least two values");
        }

        Map<Integer, Integer> results = new HashMap<>();
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i = 0; i < arr.length ; i++) {
            nums.put(i, arr[i]);
        }

        for (int i = 0; i < arr.length ; i++) {
            if(nums.containsValue(sum - arr[i])){
                results.put(sum-arr[i], arr[i]);
            }
        }

        return results;
    }


    public static void main(String[] args) {
       /*Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            isFib(n);
        }
        //isFib(1L);
        /*int [] arr = {10,7,5,8,11,9};
        randomSuffle(arr);
        System.out.print("");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            numOfSquares(a, b);
        }
        //int count = numOfSquares(3,9);
        //System.out.println(count);*/
        //System.out.println(multiplyMem(0L, 1L));
        //System.out.println(multiply(11,30000));
        //System.out.println(divide(3));
        //printArray(0, arr.length -1, arr);
        //int [] arr = {5,-9,6,-2,3};
        int [] arr = {2,7,8,1,12,4,10,8,3,11};
        pairOfSum(arr, 16);
        //System.out.println(stock_price(arr));


    }

}