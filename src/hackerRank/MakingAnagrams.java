package hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class MakingAnagrams {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int[] lettercounts = new int[26];
        for(char c : a.toCharArray()){
            lettercounts[c-'a']++;
        }
        for(char c : b.toCharArray()){
            lettercounts[c-'a']--;
        }
        int result = 0;
        for(int i : lettercounts){
            result += Math.abs(i);
        }
        return result;

    }

    private static int makeAnagram(Map<Character, Integer> freqA, Map<Character, Integer> freqB){
        int numToDelete = 0;
        for(Character chara: freqA.keySet()){
            if(!freqB.containsKey(chara)){
                numToDelete++;
            }else if(freqA.get(chara) != freqB.get(chara)){
                numToDelete += Math.abs(freqA.get(chara) - freqB.get(chara));
            }
        }

        return numToDelete;
    }

    private static Map<Character, Integer> getCharFrequency(String str){
        Map<Character, Integer> res = new HashMap<>();
        for(int i = 0; i<str.length(); i++){
            if(res.containsKey(str.charAt(i))){
                Integer freq = res.get(str.charAt(i));
                res.put(str.charAt(i), freq+1);
            }else{
                res.put(str.charAt(i), 1);
            }
        }

        return res;
    }

    public static void main(String[] args){
        System.out.print(makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke"));
    }
}
