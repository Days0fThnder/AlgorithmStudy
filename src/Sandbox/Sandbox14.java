package Sandbox;

import java.util.*;

/**
 * Created by j_rus on 5/2/2017.
 */
public class Sandbox14 {

    public static int minAbsDiff(int [] arr){
        Arrays.sort(arr);
        int min = arr[arr.length -1];
        for (int i = 0; i < arr.length-1 ; i++) {
            if(Math.abs(arr[i] - arr[i+1]) <= min){
                min = Math.abs(arr[i] - arr[i+1]);
            }
        }

        return min;
    }

    static boolean sumOfTwo(int[] a, int[] b, int v) {

        Arrays.sort(a);
        Arrays.sort(b);
        int aIndx = 0;
        int bIndx = 0;
        while(aIndx < a.length && bIndx < b.length){

        }

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i=0; i<a.length; i++){
            numMap.put(i, a[i]);
        }

        for(int i=0; i<b.length; i++){
            int compliment = v - b[i];
            if(numMap.containsValue(compliment)){
                return true;
            }
        }

        return false;

    }

    static int reverseInteger(int x) {

        String strX = Integer.toString(x);
        StringBuilder reverseStr = new StringBuilder();

        for(int i = strX.length()-1; i>=0; i--){
            reverseStr.append(strX.charAt(i));
        }
        String strRev = reverseStr.toString();
        if(strRev.charAt(strRev.length()-1) == '-'){
            strRev = '-'+strRev.substring(0, strRev.length() - 1);


        }
        System.out.print(strRev);
        return Integer.parseInt(strRev);

    }

    static int wordLadder(String beginWord, String endWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word: wordList) {
            wordSet.add(word);
        }

        int results = 0;
        int len = beginWord.length();
        String tempWord = beginWord;
        while (!tempWord.equals(endWord)){
            tempWord = beginWord;
            for (int i = 0; i <len ; i++) {
                if(i == 0){
                    tempWord = endWord.charAt(i)+beginWord.substring(1, len);
                    if(wordSet.contains(tempWord)){
                        results++;
                    }else{
                        tempWord = beginWord;
                    }
                }else {
                    tempWord = beginWord.substring(0, i)+endWord.charAt(i)+beginWord.substring(i+1, len);
                    if (wordSet.contains(tempWord)){
                        results++;
                        wordSet.remove(tempWord);
                        beginWord = tempWord;
                    }
                }
                int y =0;
            }
        }

        return results;
    }

    static String stringReformatting(String s, int k) {

        StringBuilder sb = new StringBuilder();
        int break_point = 0;
        //int end = 0;


        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) != '-' && break_point < k){
                sb.append(s.charAt(i));
                break_point++;
            }
            if( break_point == k && i > 0){
                sb.append('-');
                break_point = 0;
            }
        }

        String result = sb.reverse().toString();

        char first_char = result.charAt(0);

        if(first_char == '-'){
            String f_result = result.substring(1,result.length());
            return f_result;
        }

        return result;

    }




    public static void main(String [] arg){
        //int [] arr = {3, -7, 0};
        /*System.out.print(minAbsDiff(arr));
        int [] a = {1, 2, 3};
        int [] b = {10, 20, 30, 40};
        int v = 42;
        sumOfTwo(a, b, v);*/
        //String [] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        //wordLadder("hit", "cog", wordList);
        stringReformatting("-$?!V-30-0-%-%$", 2);
        //reverseInteger(-789);

    }
}
