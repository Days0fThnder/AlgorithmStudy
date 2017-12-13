package Sandbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class solution2 {

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> a) {
        ArrayList<Integer> result = new ArrayList<>();
        // Populate result;
        int totalSize = a.size() * a.get(0).size();
        int rowSize = a.get(0).size();
        int currentRow = 0;
        int currentCol = a.get(0).size();
        int currRowIdx = 0;
        boolean forward = true;
        while( result.size() < totalSize){
            if(currentRow == 0) {
                for (int row = currRowIdx; row < rowSize; row++) {
                    result.add(a.get(currentRow).get(row));
                }
                currentRow = a.size()-1 ;
                currRowIdx ++;
                forward = false;
            }
            if (currentCol == a.get(0).size()){
                for (int row = 1; row < a.size() ; row++) {
                    result.add(a.get(row).get(a.get(row).size()-1));
                }
                currentCol = 0;
            }

            if( currentRow > 0){
                if(!forward){
                    for (int row = (a.size()- 1) - currRowIdx; row >= 0 ; row--) {
                        result.add(a.get(currentRow).get(row));
                    }
                }

            }

        }
        return result;
    }

    public String largestNumber(final List<Integer> a) {

        List<Integer> results = myCompare(a);
        return results.get(0).toString();
    }

    private List<Integer> myCompare(List<Integer> a) {
        if(a.size() < 2){
            return a;
        }

        List<Integer> newVals = new ArrayList<>();

        for (int i = 0; i < a.size()-1 ; i+=2) {
            Integer num1 = a.get(i);
            Integer num2 = a.get(i+1);
            String val_1 = num1.toString() + num2.toString();
            String val_2 = num2.toString() + num1.toString();

            if(Integer.parseInt(val_1) >= Integer.parseInt(val_2)){
                newVals.add(Integer.parseInt(val_1));
                //a.remove(i+1);
            }else{
                newVals.add(Integer.parseInt(val_2));
                //a.remove(i+1);
            }

        }

        if(a.size()%2 == 1){
            newVals.add(a.get(a.size()-1));
        }

        return myCompare(newVals);
    }

    public ArrayList<Long> plusOne(ArrayList<Integer> a) {

        Long currentValue = 0L;
        ArrayList<Long> results = new ArrayList<>();
        for(int i = 0; i < a.size(); i++){
            if(i == 0 ){
                currentValue = currentValue + a.get(i);
            }else{
                currentValue = currentValue*10;
                currentValue = currentValue + a.get(i);
            }
        }

        currentValue = currentValue + 1;
        while(currentValue > 0){
            results.add(currentValue%10);
            currentValue = currentValue/10;
        }

        Collections.reverse(results);

        return results;
    }

    public static void main(String [] arg){
        solution2 su2 = new solution2();
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(30);
        a.add(34);
        a.add(5);
        a.add(9);
        su2.largestNumber(a);
    }
}
