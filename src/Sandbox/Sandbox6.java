package Sandbox;

/**
 * Created by j_rus on 4/5/2017.
 */
public class Sandbox6 {

    public static int findRotation (String [] words){
        int start = 0;
        int end = words.length -1;

        return findRotation(words, start, end);
    }

    private static int findRotation( String [] words, int start, int end){
        if(start <= end){
            int mid = (end+start)/2;
            if(words[mid].compareToIgnoreCase(words[mid -1]) < 0){
                return mid;
            }else if((words[mid].compareToIgnoreCase(words[start]) > 0) &&
                    (words[mid].compareToIgnoreCase(words[end]) > 0)){
                return findRotation(words, mid+1, end);
            }else if(words[mid].compareToIgnoreCase(words[end]) < 0){
                        return findRotation(words, start, mid-1);
            }
        }

        return -1;
    }

    public static void main(String [] arg){
        String[] words = new String[]{
                "ptolemaic",
                "retrograde",
                "supplant",
                "undulate",
                "xenoepist",
                "asymptote", // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };

        System.out.print(findRotation(words));
    }

}
