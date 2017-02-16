package projectEuler;

/**
 * Created by j_rus on 1/29/2017.
 */
public class problem3 {

    private static boolean isPrime(long n){
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }


    public static long largestPrimeFac(long value){
        long largest = 0;
        for (long i = 2; i <= value ; i++) {
            if (value%i == 0 && isPrime(i)){
                //largest = i;
                value = value/i;
                largest = i;
            }
        }
        return largest;
    }

    public static void main(String [] arg){
        System.out.println(largestPrimeFac(600851475143l));
        System.out.print(isPrime(6857));
    }
}
