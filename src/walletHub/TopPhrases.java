package walletHub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopPhrases {


    /**This method reads the large file through a stream without storing it in memory and then uses a
     * scanner to parse the file and obtain each phrase and its frequency storing it in a map and then
     * sorting that map and out putting the top 100000 phrases in an array.
     * The time complexity for this method (O(n) + (O(m log(m)) + O(m))) where n is length of the file line by line, for the outer loop
     * plus O(m log(m)) + O(m) for sorting and reversing the map.
     * For the inner loop it runs in constant time because each line has 50 phrases.
     * The space complexity is O(n) since we store the phrases and their frequency in a map**/
    public String [] findTheTopPharse(String path) throws IOException {
        FileInputStream inputStream = null;
        Scanner sc;
        Map<String, Integer> phraseCount = new HashMap<>();
        String [] result = new String[5];
        try{
            inputStream = new FileInputStream(path);
            sc = new Scanner(inputStream);
            while(sc.hasNextLine()){
                for (String phrase : sc.nextLine().split("\\|")) {
                    if(phraseCount.containsKey(phrase)){
                        phraseCount.put(phrase, phraseCount.get(phrase)+1);
                    }else{
                        phraseCount.put(phrase, 1);
                    }
                }
            }
        }finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        // We sort the phrases map and place the keys in our result array
        // This loop has a O(1) run time because it breaks when the result array
        // has reached 100000
        Map<String, Integer> sortPhrases = sortByValue(phraseCount);
        int resultIdx = 0;
        for (String phrase: sortPhrases.keySet()) {
           if(resultIdx < result.length) {
               result[resultIdx] = phrase;
               resultIdx++;
           }else {
               break;
           }
        }

        return result;
    }

    /***
     * This method sorts the map generated after parsing the file, the map contains the phrases and their frequency
     * this method's time complexity is O(n log(n)) + O(n) for the sort and reversal of the list. The space complexity is
     * O(n) for the new sorted map that is returned*/

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(unsortMap.entrySet());

        Collections.sort(list, Comparator.comparing(o -> (o.getValue())));

        Collections.reverse(list);

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
