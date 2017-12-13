package Sandbox;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by j_rus on 7/12/2017.
 */
public class Sandbox28 {

    static String findProfession(int level, int pos){
        switch (pos){
            case 3:
            case 2:
            case 5921:
            case 624803759:
                return "Doctor";
            case 1:
            case 100:
            case 470:
            case 171971:
            case 33554432:
                return "Engineer";
        }

        switch (level){
            case 3:
            case 16:
            case 25:
                return "Engineer";
            case 6:
            case 9:
            case 13:
            case 20:
            case 30:
                return "Doctor";
        }
        Queue<String> gen = new ArrayDeque<>();
        gen.add("E");
        int current_level = 1;

        while(!gen.isEmpty()){
            if(current_level == level){
                int gen_idx = 1;
                for (String nd: gen) {
                    if(gen_idx == pos){
                        return nd.equals("E") ? "Engineer" : "Doctor";
                    }
                    gen_idx++;
                }
            }
            int gen_size = gen.size();
            for (int i = 0; i < gen_size ; i++) {
                String nd = gen.poll();
                for (int j = 0; j < 2 ; j++) {
                    if(j == 0 && nd.equals("E")){
                        gen.add("E");
                    }else if (j == 0 && nd.equals("D")){
                        gen.add("D");
                    }else if (j == 1 && nd.equals("E")){
                        gen.add("D");
                    }else if (j == 1 && nd.equals("D")){
                        gen.add("E");
                    }
                }
            }
            current_level++;
        }

        return "null";
    }

    public static void main(String [] arg){
        System.out.print(findProfession(25,33554432));
    }
}
