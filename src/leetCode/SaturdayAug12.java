package leetCode;

import java.util.*;

public class SaturdayAug12 {


    public boolean judgeCircle(String moves) {

        Map<Character, Integer> leftRightMap = new HashMap<>();
        Map<Character, Integer> upDownMap = new HashMap<>();

        leftRightMap.put('L', 0);
        leftRightMap.put('R', 0);
        upDownMap.put('D', 0);
        upDownMap.put('U', 0);

        for (Character ch: moves.toCharArray()) {

            if(ch == 'L' || ch == 'R'){
                leftRightMap.put(ch, leftRightMap.get(ch)+1);
            }else if (ch == 'D' || ch == 'U'){
                upDownMap.put(ch, upDownMap.get(ch)+1);
            }

        }

        if(leftRightMap.get('L').equals(leftRightMap.get('R')) &&
                upDownMap.get('D').equals( upDownMap.get('U'))){
            return true;
        }else{
            return false;
        }

    }

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

        int xlocation = Collections.binarySearch(arr, x);
        List<Integer> results = new ArrayList<>();
        int up=0;
        int down =0;
        int start = 0;
        int end = arr.size()-1;

        while (results.size() < k){
            if(xlocation < 0){
                if(x > arr.get(end)){
                    results.add(arr.get(end));
                    end--;
                }else if (x < arr.get(start)){
                    results.add(arr.get(start));
                    start++;
                }else{
                    for (Integer in: arr) {
                        if(Math.abs(in - x) == 1){
                            xlocation = arr.indexOf(in);
                            break;
                        }
                    }
                }
            }else{
                results.add(arr.get(xlocation));
                up = xlocation + 1;
                if(xlocation != 0)
                    down = xlocation -1;

                while ((up <= end || down >= 0) && results.size() < k){
                    if(Math.abs(arr.get(up) - x) >  Math.abs(arr.get(down) - x)){
                        results.add(arr.get(down));
                    }else{
                        results.add(arr.get(up));
                    }

                    up++; down--;
                    if(down < 0){
                        break;
                    }
                }

                while(results.size() < k){
                    xlocation++;
                    results.add(arr.get(xlocation));
                }
            }
        }

        Collections.sort(results);
        return results;

    }

    public static void main(String [] arg){
        SaturdayAug12 obj = new SaturdayAug12();
        List al = new ArrayList();
        Integer [] arr ={0,0,0,1,3,5,6,7,8,8};
        for (int i = 1; i < 6 ; i++) {
            al.add(i);
        }
        obj.findClosestElements(Arrays.asList(arr), 2, 2);

    }
}
