package Sandbox;

import java.util.Arrays;

/**
 * Created by j_rus on 6/20/2017.
 */
public class Sandbox21 {

    static boolean riffledSchuffle (int [] cards, int[] halvesArr){
        int [] half1 = Arrays.copyOfRange(halvesArr, 0, halvesArr.length/2);
        int [] half2 = Arrays.copyOfRange(halvesArr, halvesArr.length/2, halvesArr.length);
        int len1 = half1.length;
        int len2 = half2.length;
        int idx_1 = 0;
        int idx_2 = 0;

        for (int i = 0; i < cards.length ; i++) {

            int card = cards[i];
            if(idx_1 < len1 && card == half1[idx_1]){
                idx_1++;
            }else if(idx_2 < len2 && card == half2[idx_2]){
                idx_2++;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void main(String [] arg){
        int [] cards = {1,2,3,4,5,6,7,8,9,10};
        int [] notRiffef = {1,6,2,7,3,8,4,9,5,10};
        riffledSchuffle(cards, notRiffef);
    }
}
