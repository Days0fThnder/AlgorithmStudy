package dailycoding.minIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntervalActions {

    public int intervalsToRemove(List<Interval> intervalsList){

        if(intervalsList.isEmpty() || intervalsList.size() == 1){
            return 0;
        }

        Collections.sort(intervalsList);
        int minCounter = 0;
        for(int i = 0; i < intervalsList.size()-1; i++){
            if(intervalsList.get(i).getEnd() > intervalsList.get(i+1).getStart()){
                minCounter++;
            }
        }
        return minCounter;
    }

    public static void main(String [] args){
        IntervalActions intervalActions = new IntervalActions();
        List<Interval> intervals = new ArrayList<>();
        /*intervals.add(new Interval(7,9));
        intervals.add(new Interval(6,10));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,8));*/
        intervals.add(new Interval(0,1));
        intervals.add(new Interval(1,2));
        System.out.println(intervalActions.intervalsToRemove(intervals));
    }
}
