package InterviewBits;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
        int t = 0, repeat, missing, diff = 0;
        long diffSq = 0, sum = 0;
        for(int i=0;i< a.size();i++){
            diff = (i + 1) - a.get(i);
            sum = i+1+a.get(i);
            t+= diff;
            diffSq += diff*sum;

        }
        sum = diffSq/t;
        missing = (int) ((t+sum)/2);
        repeat = (int) ((sum-t)/2);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(repeat);
        list.add(missing);
        return list;
    }


    public static void main(String [] arg){
        Arrays ar = new Arrays();
        List<Integer> list = new ArrayList<>();
        int [] B = {3, 1, 2, 5, 3};
        for (int i = 0; i < B.length ; i++) {
            list.add(B[i]);
        }
        ar.repeatedNumber(list);
    }
}
