package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by j_rus on 10/5/2016.
 */
public class interviewCake2 {
    static Map<Integer, Integer> delivery_ids = new HashMap<>();

    static Integer findUnique(int ids[]){
        int frequency = 0;
        for (int i = 0; i < ids.length; i++){
            if(delivery_ids.containsKey(ids[i])){
                delivery_ids.put(ids[i], delivery_ids.get(ids[i] + 1));
            }else{
                delivery_ids.put(ids[i], ++frequency);
                frequency = 0;
            }
        }

        for (Integer id: delivery_ids.keySet()) {
            if(delivery_ids.get(id) == 1){
                return delivery_ids.get(id);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        int ids[] = {3,5,7,3,6,8,2,1,2,6,8,7,5};
        System.out.println(findUnique(ids));
    }
}

