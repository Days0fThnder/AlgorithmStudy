package dailycoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermNumber {



    public static int nextPerm(int num){
        String stNum = String.valueOf(num);
        char[] chars = stNum.toCharArray();
        List<Integer>  numList = new ArrayList<>();
        permString.printPermutn(stNum, "", numList, num);
        Collections.sort(numList);
        return numList.get(0);
    }

    private static void  swap(int a, int b, char[] chars){
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String args []){
        System.out.println(nextPerm(48975));
    }
}
