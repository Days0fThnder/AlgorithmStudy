package Sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j_rus on 3/29/2017.
 */
public class Sandbox5 {

    public static boolean in_flight_mv(int flight_len, List<Integer> mv_len){

        int rtime = flight_len;
        int hold_time = flight_len;

        for (int mv: mv_len) {
            hold_time = rtime;
            rtime = rtime - mv;
            if (rtime == 0){
                return true;
            }else if(rtime < 0){
                rtime = hold_time;
            }
        }
        return false;
    }

    public static void main(String [] arg){
        List<Integer> mv_len = new ArrayList<>();
        mv_len.add(60);
        in_flight_mv(150, mv_len);
    }
}
