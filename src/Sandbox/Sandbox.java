package Sandbox;

import java.util.*;
import NodeLib.Node;

/**
 * Created by j_rus on 5/2/2016.
 */
public class Sandbox {

    static LinkedList<String> listNode = new LinkedList();
    static HashMap<String, Integer> wordMap = new HashMap<>();
    static Integer lo = new Integer(0);
    static int wordFrequency = 0;
    public LinkedList<String> buildList(){
        listNode.add("a");
        listNode.add("b");
        listNode.add("c");
        listNode.add("d");
        return listNode;
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;

            }
        }
        return table;
    }
     public static boolean isPalindrone(String phrase){
         int countOdd = 0;
         int [] freqTable = buildCharFrequencyTable(phrase);
         for(int i = 0; i<= freqTable.length -1; i++){
             if(freqTable[i] > 0){
                 if(freqTable[i]%2 == 1){
                     countOdd++;
                 }
             }
         }
         if(countOdd <= 1){
             return true;
         }
             return false;
     }

    public static int fibOptimal(int n){
        return fibOptimal(n, new int[n + 1]);

    }
    public static int fibOptimal(int n, int[] memo){

        if((n == 0) || (n == 1)) return n;

        if(memo[n] == 0){
            memo[n] = fibOptimal(n - 1, memo) + fibOptimal(n - 2, memo);
        }

        return memo[n];
    }

    public static HashMap getAlphabetMap(){
        String alphaString ="abcdefghijklmnopqrstuvwxyz";
        int i = -1;
        HashMap<Integer, Character> alphaMap = new HashMap<>();
        for(Character c : alphaString.toCharArray()){
            alphaMap.put(++i, c);
        }
        return alphaMap;
    }

    public static String compress_string(String str){
        int original_str_length = str.length();
        if(str.length() == 1)
            return str;

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int letterCounter[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1 ];

        StringBuilder bltStr = new StringBuilder();
        for(char c :str.toCharArray()){
            int val = Character.getNumericValue(c);
            int i = 0;
            if (a <= val && val <= z) {
                i = val - a;
            }
            letterCounter[i]++;
        }
        for(int i =  0; i<=letterCounter.length - 1; i++){
            if( letterCounter[i] > 0)
                bltStr.append(getAlphabetMap().get(i).toString() + letterCounter[i]);
        }
        String compressedString = bltStr.toString();
        if(compressedString.length() < original_str_length)
            return compressedString;
        else
            return str;
    }

    public static boolean isOneEdit( String strA, String strB){
        int editCounter = 0;
        int len = 0;
        if(strA.length() > strB.length())
            len = strB.length() - 1;
        else
            len = strA.length() - 1;
        if(strA.length() > strB.length() || strA.length() < strB.length()){
            editCounter ++;
            for(int i = 0; i <= len; i++){
                if(strA.charAt(i) != strB.charAt(i))
                    editCounter++;
            }

        }else if (strA.length() == strB.length()){
            for (int i = 0; i <= strA.length() - 1; i++){
                if(strA.charAt(i) != strB.charAt(i)){
                    editCounter++;
                }

            }
        }
        if(editCounter == 1)
            return true;
        else
            return false;
    }

    static void swapA( int a, int b){
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println( "value of a: "+ a + " value of b: " + b);

    }



    static int wordFrequency(String searchTerm, String[] words){
        if(wordMap.get(searchTerm) != null){
            wordFrequency = wordMap.get(searchTerm);
            return wordFrequency;
        }else{
            for (String word : words){
                if(word.equals(searchTerm)){
                    wordFrequency ++;
                    wordMap.put(searchTerm, wordFrequency);
                }
            }
            return wordFrequency;
        }
    }

    static int factorial (int num){
        if( num == 0){
          return 1;
        }else
        return (num * factorial(num -1));
    }

    static int smallestDiff(int arrA[], int arrB[]){
        int diff = 0;
        int lowest = 0;
        for(int i = 0; i < arrA.length; i++){
            for(int k = 0; k < arrB.length; k++){
                if(arrA[i] == arrB[k]){
                    return arrA[i] - arrB[k];
                }else{
                    diff = arrA[i] - arrB[k];
                    if( diff < 0)
                        continue;
                    else
                        if(lowest > diff || lowest == 0)
                            lowest = diff;
                }
            }
        }
        return lowest;
    }

    public static Integer flipBit(int [] num){
       int numOfOnes = 0, oneSeq = 0, zeroSeq = 0;
        List<Integer> oneSeqArr = new ArrayList<>();
        for (int i = 0; i <= num.length - 1; i++){

            if(num[i] == 1){
                numOfOnes++;
                if(zeroSeq > 1){
                    zeroSeq = 0;
                }
            }else if (num[i] == 0){
                zeroSeq++;
                if(zeroSeq > 1){
                    oneSeq =0;
                    numOfOnes=0;
                }
            }

            if(zeroSeq == 1 && numOfOnes > 0){
                oneSeqArr.add(numOfOnes);
                numOfOnes = 0;
                oneSeq = 0;
                zeroSeq = 0;
            }

            if( (i == num.length - 1) && (num[i] == 1)){
                oneSeqArr.add(numOfOnes);
            }
        }
        int size = oneSeqArr.size();
        Collections.sort(oneSeqArr);
        int num1 = 0;
        int num2 = 0;
        if(size > 2) {
             num1 = oneSeqArr.get(size - 1);
             num2 = oneSeqArr.get(size - 2);
        }else{
            return oneSeqArr.get(size - 1) + 1;
        }
        return num1 + num2 + 1;

    }


    public boolean isValidBST(Node root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(Node p, double min, double max){
        if(p==null)
            return true;

        if(p.getData() <= min || p.getData() >= max)
            return false;

        return isValidBST(p.getLeft(), min, p.getData()) && isValidBST(p.getRight(), p.getData(), max);
    }


    public static void main(String arg[]){

        //System.out.println(isPalindrone("ro"));
        //isOneEdit("pale","ple");
        //getAlphabetMap();
        //compress_string("axxxccfffyyyva");
        //fibOptimal(5);
        //swap( 45, 6);
        //int [] num = {1,1,0,1,1,1,0,1,1,0,0,1,1,0};
        //int seq = flipBit(num);
        //System.out.print(seq);
        /*
        String [] words = {"Test","wait", "Test", "Test"};
        int count = wordFrequency("Test",words);
        int count2 = wordFrequency("Test",words);
        System.out.print(count+", "+ count2);

        int arrA[] = {1, 3, 15, 11, 5, 7};
        int arrB[] = {23, 127, 235, 19, 2};
        int small = smallestDiff(arrA, arrB);
        int fac = factorial(5);
        System.out.println(fac);
        System.out.println(small);

        Node root = new Node(7);
        Node child3 = new Node(3);
        Node child10 = new Node(10);
        Node child11 = new Node(11);
        Node child2 = new Node(2);
        Node child13 = new Node(13);

        root.setLeft(child3);
        root.setRight(child10);
        child3.setLeft(child2);
        child3.setRight(child13);
        child10.setLeft(child11);
        //boolean isBST = isBinarySearchTree(root);
        Sandbox sandbox = new Sandbox();
        boolean isBST = sandbox.isValidBST(root);
        if(isBST){
            System.out.print("True");
        }else{
            System.out.print("False");
        }*/

        System.out.println(fibOptimal(5));
        System.out.println(13/2);

    }
}
