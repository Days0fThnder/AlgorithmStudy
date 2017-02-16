package google;

/**
 * Created by j_rus on 10/8/2016.
 */
public class SolutionD {

    int [] mergedArray;
    public int [] mergeArrays( int [] a, int [] b){
        if(a.length == 0 && b.length == 0){
            return a;
        }
        if(a.length >= 1 && b.length < 1){
            return a;
        }
        if(a.length  < 1 && b.length >= 1){
            return b;
        }
        int a_i = 0;
        int b_i = 0;
        mergedArray = new int[a.length + b.length];
        for (int i = 0; i < mergedArray.length ; i++) {
            if(a_i >= a.length && b_i < b.length){
                mergedArray[i] = b[b_i];
            }else if(b_i >= b.length && a_i < a.length){
                mergedArray[i] = a[a_i];
            }else if (a[a_i] < b[b_i]) {
                mergedArray[i] = a[a_i]; a_i++;
            }else if (a[a_i] > b[b_i] ) {
                mergedArray[i] = b[b_i]; b_i++;
            }
        }

        return mergedArray;

    }

    public static void main(String [] arg){
        SolutionD sd = new SolutionD();
        int [] a = {1,3,4,5,7,8,9,78,80};
        int [] b = {2,6,10,15,17,18,19,50,87};
        int [] c = sd.mergeArrays(a, b);
        for (int i = 0; i < c.length ; i++) {
            System.out.println(c[i]);
        }

    }
}
