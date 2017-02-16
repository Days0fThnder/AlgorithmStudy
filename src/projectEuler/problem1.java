package projectEuler;

/**
 * Created by j_rus on 1/21/2017.
 */
public class problem1 {

    public static void main(String [] arg){

        int sum = 0;
        for (int i = 1; i < 1000 ; i++) {
            if(i%3 == 0 || i%5 == 0){
                sum += i;
            }
        }

        System.out.print(sum);
    }
}
