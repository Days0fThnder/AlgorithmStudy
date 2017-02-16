package google;


import java.util.Collections;

/**
 * Created by j_rus on 10/9/2016.
 */
public class DynamicIntArray {

    private int array[];
    private int size = 0;

    public DynamicIntArray(){
        array = new int [10];
    }

    public void add (int n){
        int lastIndex = array.length - 1;
        if(array[lastIndex] == 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = n;
                    //size++;
                    return;
                }
            }
        }else {

            int tempArray[] = array;
            array = new int[tempArray.length * 2];
            for (int i = 0; i < tempArray.length; i++) {
                array[i] = tempArray[i];
            }
            if (array[tempArray.length] == 0) {
                array[tempArray.length] = n;
                //size++;
            }
        }
    }

    public int elementAt(int index){
        try {
            return array[index];
        }
        catch(IndexOutOfBoundsException e) {
            return -1;
        }
    }

    public static int searchDA( DynamicIntArray arr, int target){
            if(target < 0 || arr.elementAt(0) < 0){
                return -1;
            }

            int index = 0; int elemIndex = 0; int size =1;
            while(index >= 0){
                index = arr.elementAt(elemIndex);
                size++; elemIndex++;
            }
            return binarySearch(0, size - 1, arr, target);
    }

    public static int binarySearch(int first, int last, DynamicIntArray arr, int search) {

        if(last >= first){
            int mid = first + (last - first)/2;
            if(arr.elementAt(mid) == search){
                return mid;
            }
            else if(search < arr.elementAt(mid) )
                return binarySearch( first, mid - 1, arr, search);
            else if(search > arr.elementAt(mid)){
                return binarySearch( mid + 1, last, arr, search);
            }
        }
        return -1;

    }

    public static void main(String [] arg){
        DynamicIntArray arr = new DynamicIntArray();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        //arr.add(11);
        //arr.add(12);
        System.out.println(searchDA(arr, 7));

        /*for (int i = 0; i < arr.size - 1; i++) {

        }*/
    }
}
