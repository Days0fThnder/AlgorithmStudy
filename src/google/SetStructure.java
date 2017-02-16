package google;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by j_rus on 10/18/2016.
 */
public class SetStructure {

    private Object [] setArray;
    private Map<Object, Integer> setMap;
    private int size;
    private int index;

    public SetStructure(){
        setArray = new Object[10];
        setMap = new HashMap<>();
        index = -1;
        size = 0;
    }
    public void insert( Object obj){
        if(obj == null){
            return;
        }
        setMap.put(obj, ++index);
        ++size;
    }

    public void remove( Object obj){
        if(size == 0){
            return;
        }
        int nullIndex = -1; // index of the object to be removed
        for (int i = 0; i <= size - 1 ; i++) {
            if(setArray[i].equals(obj)){
                setArray[i] = null;
                nullIndex = i;
                break;
            }
        }
        if(nullIndex != -1 && size == 1 ) {
            --size;
            return;
        }
        // This loop is for sliding the elements back  into place
        //after removal
        for (int i = nullIndex; i <= size - 2; i++){
            setArray[i] = setArray[i + 1];
            // the last object, we will set it to null at the end
            if(i == size - 2) {
                setArray[i + 1] = null;
                --size;
                break;
            }
        }
    }

    public Object getRandomElement(){
        if(size > 0) {
            Random randomGenerator = new Random();
            int randomElemIndex = randomGenerator.nextInt(size);
            return setArray[randomElemIndex];
        }else{
            System.out.println("Set is empty");
            return null;
        }
    }


    public static void main(String [] arg){
        SetStructure ss = new SetStructure();
        ss.insert(new Integer(10));
        ss.insert(new Integer(5));
        ss.insert(new Integer(11));
        ss.insert(new Integer(13));
        ss.insert(new Integer(1));
        ss.insert(new Integer(30));
        ss.insert(new Integer(33));
        ss.insert(new Integer(8));
        ss.insert(new Integer(0));
        ss.insert(new Integer(34));
        ss.insert(new Integer(12));
        ss.insert(new Integer(35));
        ss.insert(new Integer(67));
        ss.insert(new Integer(2));
        ss.remove(new Integer(10));
        Integer num = (Integer) ss.getRandomElement();
        System.out.println("Random object: "+ num);
    }
}
