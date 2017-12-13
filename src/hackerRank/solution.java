package hackerRank;

/**
 * Created by j_rus on 3/18/2017.
 */
public class solution {

    static void fizzBuzz(){
        for (int i = 1; i <= 15 ; i++) {
            if( i % 5 == 0 && i % 3 == 0){
                System.out.println("FizzBuzz");
            }
            else if( i % 3 == 0 ){
                System.out.println("Fizz");
            }
            else if( i % 5 == 0 ){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }

    public static void main(String [] arg){
        fizzBuzz();
    }
}
