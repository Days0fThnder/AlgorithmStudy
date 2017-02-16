package projectEuler;

/**
 * Created by j_rus on 2/12/2017.
 */
public class problem6 {

    public int sum_sqr_diff(int limit){
        int sum_squares = 0;
        int square_sum = 0;
        int sum_difference;
        for (int j = 1; j <= limit; j++) {
            sum_squares += (int)Math.pow(j,2);
            square_sum += j;
        }
        square_sum = (int)Math.pow(square_sum, 2);
        sum_difference = square_sum - sum_squares;

        return Math.abs(sum_difference);
    }

    public static void main(String [] args){
        problem6 p6 = new problem6();
        System.out.print(p6.sum_sqr_diff(100));
    }

}
