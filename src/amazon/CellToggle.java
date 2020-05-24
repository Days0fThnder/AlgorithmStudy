package amazon;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import sun.text.resources.zh.CollationData_zh_TW;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class CellToggle
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days)
    {
        // WRITE YOUR CODE HERE
        int out = 0;
        int oldval = 0;
        int celVal;
        List results;
        for(int i = 1; i <= days; i++){
            for(int j = 0; j < states.length; j++ ){
                if(j == 0){
                    celVal = toggle(out, states[j], states[j + 1]);
                }else if(j == states.length-1){
                    celVal = toggle(oldval, states[j], out);
                }else{
                    celVal = toggle(oldval, states[j], states[j+1]);
                }
                oldval = states[j];
                states[j] = celVal;
            }
        }

        results = Arrays.asList(states);

        return results;

    }

    private int toggle(int old, int curr, int next){
        if(old == next){
            return 0;
        }

        return 1;
    }
    // METHOD SIGNATURE ENDS

    public static void main(String [] args){
        CellToggle cellToggle = new CellToggle();
        int [] arr = {1,0,0,0,0,1,0,0};
        cellToggle.cellCompete(arr, 1);

        for (int in : arr) {
            System.out.print(in+" ");
        }

    }
}
