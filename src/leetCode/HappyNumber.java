package leetCode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {

        if(n == 1)
            return true;

        int res = 0;
        int current = n;
        Set<Integer> sums = new HashSet<>();

        while(current > 0){
            int num1 = (current%10);
            res += (num1*num1);
            current = current/10;

            if(res == 1 && current == 0){
                return true;
            }

            if(current == 0){
                if(sums.contains(res)){
                    return false;
                }
                current = res;
                sums.add(res);
                res = 0;
            }

        }

        return false;


    }

    public static void main(String [] args){
        HappyNumber happyNumber = new HappyNumber();

        System.out.print(happyNumber.isHappy(3));
    }
}
