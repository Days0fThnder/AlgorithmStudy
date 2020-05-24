package dailycoding;

import java.util.*;

public class LargestInteger {

    public Integer getLargestInteger(int [] arr){
        Map<Integer, PriorityQueue<Integer>> mappedNumbers = getOrderedNumbers(arr);
        StringBuilder sb = new StringBuilder();

        for(Integer in : mappedNumbers.keySet()){
            for(Integer num : mappedNumbers.get(in)) {
                sb.append(num);
            }
        }

        return Integer.parseInt(sb.toString());
    }

    private Map<Integer, PriorityQueue<Integer>> getOrderedNumbers(int [] arr){

        Map<Integer, PriorityQueue<Integer>> mappedNumbers = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length ; i++) {
            mapNumber(arr[i], mappedNumbers);
        }

        return mappedNumbers;

    }

    private void mapNumber(int n, Map<Integer, PriorityQueue<Integer>> numbersMap){
        String number = String.valueOf(n);

        Integer firstDigit = Integer.parseInt(number.substring(0,1));

        if(numbersMap.containsKey(firstDigit)){
            numbersMap.get(firstDigit).add(n);
        }else{
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            priorityQueue.add(n);
            numbersMap.put(firstDigit, priorityQueue);
        }
    }

    public static void main(String [] args){
        int [] arr = {10, 7, 76, 415};
        LargestInteger largestInteger = new LargestInteger();
        largestInteger.getLargestInteger(arr);

    }
}
