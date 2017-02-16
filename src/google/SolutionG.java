package google;

/**
 * Created by j_rus on 10/17/2016.
 */
public class SolutionG {

    public static boolean sumExists(int[] arr, int targetVal){
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr.length ; j++) {
                if(i == j){
                    continue;
                }else if (arr[i] + arr[j] == targetVal){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String [] arg){
        int [] arr = {5,6,7,8,3,5,1};
        int targetVal = 9;
        boolean exists = sumExists(arr, targetVal);
        System.out.print(exists);
    }
}
