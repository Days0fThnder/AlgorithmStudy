package InterviewBits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Factors {

    public ArrayList<Integer> allFactors(int a) {

        ArrayList<Integer> result = new ArrayList<>();
        Integer a_val = a;
        Double sq = Math.sqrt(a_val);
        for(int i = 1; i <= Math.sqrt(a_val); i++){
            if(a%i == 0){
                result.add(i);
                if(i != Math.sqrt(a_val.doubleValue())){
                    result.add(a/i);
                }
            }
        }
        Collections.sort(result);

        return result;
    }

    public ArrayList<Integer> allFactorsA(int a) {
        ArrayList<Integer> resh = new ArrayList<>();
        LinkedList<Integer> rest = new LinkedList<>();
        int f=1;
        while (f<=Math.sqrt(a)) {
            if (a % f == 0) {
                resh.add(f);
                if (a/f!=f) {
                    rest.addFirst(a/f);
                }
            }
            f++;
        }
        resh.addAll(rest);
        return resh;
    }

    /*public boolean isPower(int a) {

        if(Math.pow(Math.sqrt(a), 2) == a){
            return true;
        }
        if(a == 1){
            return true;
        }

        for (int i = 2; i <= a ; i++) {
            if(Math.pow(2, i))
        }

        return false;
    }*/

    public static void main(String [] arg){
        Factors ft = new Factors();
        ft.allFactorsA(12);

        //ft.isPower(9);


    }
}
