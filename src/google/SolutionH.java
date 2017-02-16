package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by j_rus on 11/2/2016.
 */
public class SolutionH {

    public int stickCut(int sticks, ArrayList<Integer> lengths){
        if (lengths.isEmpty()){
            return 0;
        }
        TreeSet<Integer> lengthSet = new TreeSet<>();
        int newCutLength;
        System.out.println(sticks);
        for (int i = 0; i < sticks; i++) {
            lengthSet.add(lengths.get(i));
        }
        int smallestVal = lengthSet.pollFirst();
        for (int i = 0; i < sticks; i++) {
            newCutLength = lengths.get(i) - smallestVal;
            lengths.set(i, newCutLength);
            if(newCutLength == 0){
                lengths.remove(i);
                --sticks;
                i--;
            }
        }
        return stickCut(sticks, lengths);
    }

    /*private int stickCut (int sticks, ArrayList<Integer> lengths ){
        if (lengths.isEmpty()){
            return 0;
        }
        TreeSet<Integer> lengthSet = new TreeSet<>();
        int newCutLength;
        for (int i = 0; i < sticks; i++) {
            lengthSet.add(lengths.get(i));
        }
        int smallestVal = lengthSet.pollFirst();
        for (int i = 0; i < sticks; i++) {
            newCutLength = lengths.get(i) - smallestVal;
            lengths.set(i, newCutLength);
            if(newCutLength == 0){
                lengths.remove(i);
                --sticks;
                i--;
            }
        }
        System.out.println(sticks);
        return stickCut(sticks, lengths);
    }*/

    public static void main(String [] arg){
        SolutionH sh = new SolutionH();
        int [] stickLefts = {5, 4, 4, 2, 2, 8};
        ArrayList<Integer> stickLenghts = new ArrayList<>();
        for (int i = 0; i < stickLefts.length ; i++) {
            stickLenghts.add(stickLefts[i]);
        }
        sh.stickCut(6, stickLenghts);
    }
}
