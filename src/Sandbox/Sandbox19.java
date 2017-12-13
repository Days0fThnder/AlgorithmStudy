package Sandbox;

/**
 * Created by j_rus on 6/12/2017.
 */
public class Sandbox19 {

    static int findFirstOcc(String s, String x){
        int x_len = x.length();

        for (int i = 0; i < s.length() ; i++) {
            if(i+(x_len-1) < s.length()){
                String str = s.substring(i, (i+x_len));

                if(s.substring(i, (i+x_len)).equals(x)){
                    return i;
                }
            }
        }

        return -1;
    }

    static int findFirstOccO(String s, String x){
        int x_len = x.length();
        StringBuilder sb = new StringBuilder();
        int startIdx = 0;
        for (int i = 0; i <= s.length() ; i++) {
            if(sb.length() < x_len){
                if(sb.length() == 0){
                    startIdx = i;
                }
                sb.append(s.charAt(i));
            }else{
                if(sb.toString().equals(x)){
                    return startIdx;
                }else {
                    i = startIdx;
                    sb = new StringBuilder();
                }
            }
        }

        return -1;
    }

    static boolean almostIncreasingSequence(int[] sequence) {

        int remove_count = 0;
        Integer highest_so_far = null;
        Integer pre_highest_so_far = null;
        if(sequence.length == 2){
            return true;
        }

        for(int i = 0; i < sequence.length-1; i++){
            if(highest_so_far != null ){
                if(sequence[i+1] == highest_so_far){
                    remove_count++;
                    break;
                }else if(pre_highest_so_far != null && sequence[i+1] < pre_highest_so_far){
                    remove_count++;
                    break;
                }
            }
            if(sequence[i] >= sequence[i+1]){
                remove_count++;
                highest_so_far = sequence[i];
                if(i != 0){
                    pre_highest_so_far = sequence[i-1];
                }
            }
        }

        return remove_count == 1;

    }

    static int matrixElementsSum(int[][] matrix) {
        int sum = 0;
        boolean [] hauntedCol = new boolean[matrix[0].length];
        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length ; col++) {
                if( row == 0){
                    if(matrix[row][col] != 0) {
                        sum += matrix[row][col];
                    }else {
                        hauntedCol[col] = true;
                    }
                }else{
                    if(hauntedCol[col] != true ){
                        if(matrix[row][col] != 0) {
                            sum += matrix[row][col];
                        }else {
                            hauntedCol[col] = true;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String [] arg){
        //findFirstOccO("five", "ve");
        //int[] arr = {10,20,30,5,30,60};
        //System.out.print(almostIncreasingSequence(arr));
        int[][] matrix = {{1, 1, 1, 0},
                {0, 5, 0, 1},
                {2, 1, 3, 10}};
        matrixElementsSum(matrix);
    }
}
