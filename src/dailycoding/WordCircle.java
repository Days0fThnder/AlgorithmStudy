package dailycoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCircle {


    public boolean isWordCircle(String [] words){
        if(words.length == 0 || words.length == 1){
            return false;
        }

        Map<Character, List<String>> mappedWords = new HashMap<>();
        List<String> wrds;
        for (String str: words){
            char first = str.charAt(0);
            if(mappedWords.containsKey(first)){
                wrds = mappedWords.get(first);
            }else{
                wrds = new ArrayList<>();
            }
            wrds.add(str);
            mappedWords.put(first, wrds);
        }

        for (String str: words){
            char last = str.charAt(str.length()-1);

            if(!mappedWords.containsKey(last) || mappedWords.get(last).size() == 0){
                return false;
            }else{
                List<String> wordList = mappedWords.get(last);
                int sizeIdx = wordList.size()-1;
                wordList.remove(sizeIdx);
            }
        }

        return true;
    }

    public static void main(String [] args){
        WordCircle wordCircle = new WordCircle();
        String [] words = {"chair", "height", "racket", "touch", "tunic"};
        wordCircle.isWordCircle(words);
    }
}
