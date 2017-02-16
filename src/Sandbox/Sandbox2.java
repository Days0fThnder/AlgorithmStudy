package Sandbox;

import java.util.*;

/**
 * Created by j_rus on 7/19/2016.
 */
public class Sandbox2 {

    static Set<String> setStr = new HashSet<>();
    static Map<String, Integer> wordCount = new HashMap<>();
    public  static void perm1(String s)
    {
        permWork("", s);
    }
    private static void permWork(String prefix, String s) {
        int n = s.length();
        if (n == 0) {
            setStr.add(prefix);
            System.out.println(prefix);
        }else {
            for (int i = 0; i < n; i++)
                permWork(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }

    }

    public static int powerN(int base, int n) {
        if(n == 0)
            return 1;
        return base * powerN(base, n-1);
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    static void pAndV(int[] arr){
        //Arrays.sort(arr);
        for (int i = 1; i < arr.length ; i += 2){
                if( arr[ i - 1] < arr[i])
                swap(arr, i - 1, i);
        }
    }



        static Set<Integer> dupList = new HashSet<>();
        static  HashMap<Integer, Integer> hm = new HashMap<>();
        static  HashMap<Integer, List<String>> hm2 = new HashMap<>();

        public static Set<Integer> myFunction(int [] arr) {
            
            for(int i = 0; i < arr.length; i++){
                for(int k = i+1; k < arr.length; k++){
                    if(arr[i] == arr[k]){
                        dupList.add(arr[i]);
                    }
                }
            }
            return dupList;
        }

        public int rotationPoint(String [] arr){
            return rotationPoint(arr, 0, arr.length);
        }

        private int rotationPoint(String[] arr, int min, int max) {
            if(max >= min){
                int mid = (max + min)/2;
                int prev, next = 0;
                prev = arr[mid].compareTo(arr[mid - 1]);
                next = arr[mid].compareTo(arr[mid + 1]);

                if(prev < 0 && next < 0){
                    return mid;
                }
                else if(arr[mid].compareTo("m") > 0){
                    return rotationPoint(arr, mid, max);
                }else if(arr[mid].compareTo("m") < 0){
                    return rotationPoint(arr, min, mid);
                }
            }

            return -1;
        }

    public static void wordCloud(String str){
        for(String word: split(str)){
            if(wordCount.containsKey(word.toLowerCase()))
                wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase()) + 1);
            else
                wordCount.put(word.toLowerCase(), 1);
        }

        System.out.print("Test");
    }

    static List<String> split(String inputString) {
        List<String> words = new ArrayList<>();
        String currentWord = "";
        for (char c : inputString.toCharArray()) {
            if (c == ' ') {
                words.add(currentWord);
                currentWord = "";
            } else if (Character.isLetter(c)) {
                currentWord += c;
            }
        }
        return words;
    }

    static int[] storeCredit(int [] items, int credit){
        int tempsum, sum = 0;

        int [] itemIndices = new int[2];

        outerloop:
        for(int i = 0; i < items.length; i++){
            for(int k = 0; k < items.length; k++){
                if(i != k){
                    tempsum = items[i] + items[k];
                    if(tempsum == sum){
                        continue;
                    }
                    if(tempsum == credit){
                        itemIndices[0] = i;
                        itemIndices[1] = k;
                        break  outerloop;
                    }else if( tempsum < credit && tempsum > sum){
                        sum = tempsum;
                        itemIndices[0] = i;
                        itemIndices[1] = k;
                    }

                }
            }
        }

        return itemIndices;
    }


    public static void main(String arg[]){
        Sandbox2 sb2 = new Sandbox2();
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote", // <-- rotates here!
                "babka",
                "banoffee",
                "car",
                "domain",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        int[] itemsprices = {5, 75, 25};
        storeCredit(itemsprices, 100);
        /*String str = "abc";
        perm1(str);
        int [] arr = { 90, 31, 14, 51, 78, 90};

        int [] arrDup = {2,1,3,11,11,2,6,2, };
        System.out.println(myFunction(arrDup));

        /*pAndV(arr);

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        //int num = powerN(3, 3);*/
        wordCloud("We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake.");
        int rotation = sb2.rotationPoint(words);
        System.out.print(rotation);







    }


}
