package dailycoding;

import java.util.Map;
import java.util.TreeMap;

public class FollowerTracker {

    Map<Integer, Integer> tracker;

    public FollowerTracker() {
        this.tracker = new TreeMap<>();
    }

    public void update(Integer hour, Integer followers){
        if(tracker.containsKey(hour)){
            Integer currentFollowers = tracker.get(hour);
            tracker.put(hour, currentFollowers+followers);
        }else{
            tracker.put(hour, followers);
        }
    }

    public Integer query(Integer start, Integer end){
        if(start > end ){throw new IllegalArgumentException("Start date should less than end date");}

        if(tracker.isEmpty()){throw new IllegalArgumentException("Fill the tracker");}

        Integer followerCount = 0;

        for (int hour = start; hour <= end ; hour++) {
            followerCount += tracker.get(hour);
        }

        return followerCount;
    }

    public static void main(String [] args){
        FollowerTracker followerTracker = new FollowerTracker();

        int [] followersForToady = {3,45,6,7,84,5,6,6,4,9,0,34,6,6,0,0,0,0,0,8,9,8,0,1};

        for(int i = 0; i < followersForToady.length; i++){
            followerTracker.update(i, followersForToady[i]);
        }

        System.out.println(followerTracker.query(6,12));
    }
}
