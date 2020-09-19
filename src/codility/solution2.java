package codility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class solution2 {

    public String solutionTees(String T) {
        // write your code in Java SE 8

        char[] sizes = T.toCharArray();

        List<Integer> sizeNums = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {

            if(sizes[i] == 'S'){
                sizeNums.add(1);
            }

            if(sizes[i] == 'M'){
                sizeNums.add(2);
            }

            if(sizes[i] == 'L'){
                sizeNums.add(3);
            }
        }

        sizeNums.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();

        for (Integer in: sizeNums) {
            if(in == 1){
                sb.append("S");
            }
            if(in == 2){
                sb.append("M");
            }
            if(in == 3){
                sb.append("L");
            }
        }

        return sb.toString();
    }

    public static void main(String [] arg){
        solution2 sol = new solution2();

        System.out.println(sol.solutionTees("SMS"));
    }
}
