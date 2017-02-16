package google;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by j_rus on 9/24/2016.
 */
public class CodeJam {

    public String reverseWords( String str){

        String words[] = str.split(" ");
        String rev = "";
        for (int i = words.length - 1; i >= 0; i-- ) {
           rev += words[i] + " ";
        }

        return rev;
    }


    public int checkPattern(String [] wordsAL, String pattern) {
        int res = 0;
        String str = pattern.replaceAll("[(]", "[").replaceAll("[)]", "]");
        for(int i=0;i<wordsAL.length-1;i++) {
            if(((String) wordsAL[i]).matches(pattern.replaceAll("[(]","[").replaceAll("[)]","]")))
                res++;
        }

        return res;
    }

    public int intersections(int [] afloors, int [] bfloors, int wireNum){
        int len = afloors.length -1;
        int intersection = 0;
        if(afloors.length != bfloors.length){
            return -1;
        }
        if(wireNum == 1){
            return 0;
        }
        for(int i = 0; i <= len; i++){
            for(int j=0; j<=len; j++){
                if(i == j){
                    continue;
                }else{
                    if( isBetween(Math.max(afloors[i], bfloors[i]), Math.min(afloors[i], bfloors[i]), afloors[j]) &&
                            isBetween(Math.max(afloors[i], bfloors[i]), Math.min(afloors[i], bfloors[i]), bfloors[j])  )
                        intersection ++;
                }
            }
        }
        return intersection;
    }

    public boolean isBetween(int high, int low, int check){
        if( low > high)
                return false;
        if( (high != check && high > check) && (low != check && low < check))
            return true;
        return false;
    }

    public int numberNeeded(String first, String second) {
        Arrays.sort(first.toCharArray());
        Arrays.sort(second.toCharArray());
        int deletions = 0;
        Set<Character> anagramString = new HashSet<>();
        for(int i = 0; i < second.length(); i++){
            anagramString.add(second.charAt(i));
        }
        for (int k = 0; k < first.length(); k++){
            if(!anagramString.contains(first.charAt(k))){
                deletions ++;
            }
        }
        /*for(int i = 0; i < first.length(); i++){
            for(int k = 0; k < second.length(); k++){
                if(first.charAt(i) == second.charAt(k)){
                    anagramString.add(first.charAt(i));
                }
            }
        }*/
        return  deletions;
    }




    public static void main(String [] arg){
        CodeJam cj = new CodeJam();
        //String str = cj.reverseWords("foobar");
        String tokens[] = {"abc", "bca", "dac", "dbc", "cba"};
        int varitions = cj.checkPattern(tokens, "(ab)(bc)(ca)");

        int a [] = {6150, 4479};
        int b [] = {6151, 4480};
        int intersections = cj.intersections(a, b, b.length);

        int deletions = cj.numberNeeded("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");

        System.out.print(deletions);
    }
}
