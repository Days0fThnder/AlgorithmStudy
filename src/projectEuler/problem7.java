package projectEuler;

/**
 * Created by j_rus on 2/12/2017.
 */
public class problem7 {

    private static boolean isPrime(int n){
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static int findPrimeNumber(int target){
        if(target == 0){
            return -1;
        }
        if(target == 1){
            return 2;
        }
        int prime_so_far = 0;
        int prime_index = 1;
        int trial_index = 1;
        while (prime_index <= target ) {
            if(isPrime(trial_index)){
                prime_so_far = trial_index;
                prime_index++;
            }
            trial_index++;
        }

        return prime_so_far;
    }

    public static void main(String [] args){
        System.out.print(findPrimeNumber(10001));
    }
}
