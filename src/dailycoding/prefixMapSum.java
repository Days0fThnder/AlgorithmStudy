package dailycoding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class prefixMapSum {

    private Map<String, Integer> mp;

    public prefixMapSum(){
        mp = new HashMap<>();
    }

    public void insert(String key, Integer value){
        mp.put(key, value);
    }

    public Integer sum(String prefix){
        int sum = 0;

        for (String str: mp.keySet()){
            if(str.startsWith(prefix)){
                sum += mp.get(str);
            }
        }

        return sum;
    }


    public static void main(String [] args){
        prefixMapSum prefixMapSum = new prefixMapSum();

        prefixMapSum.insert("columnar", 3);
        prefixMapSum.insert("column", 2);

        System.out.print(prefixMapSum.sum("col"));

    }


}
