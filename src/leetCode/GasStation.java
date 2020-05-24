package leetCode;

import java.util.ArrayList;
import java.util.List;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        List<Integer> optimalStarts = findStartingPoints(gas, cost);
        int len = gas.length;
        int res = 0;
        for(Integer station : optimalStarts){
            int nextStation = station + 1;
            int start = station;
            int tank = gas[station];

            while(nextStation != start){
                if(tank < cost[station]){
                    res = -1;
                    break;
                }
                if(nextStation < len){
                    tank = (tank - cost[station]) + gas[nextStation];
                    if(station >= len-1 )
                        station = 0;
                    else
                        station++;
                    nextStation++;
                }else{
                    tank = (tank - cost[station]) + gas[0];
                    nextStation = 0;
                }
            }

            return station;

        }

        return res <= 0 ? -1 : res;

    }

    private List<Integer> findStartingPoints(int [] gas, int [] cost){
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i<gas.length; i++){
            if(gas[i]-cost[i] > 0){
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String [] args){
        GasStation gasStation = new GasStation();
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};
        gasStation.canCompleteCircuit(gas, cost);
    }
}
