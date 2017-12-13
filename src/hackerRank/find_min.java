package hackerRank;

import java.util.Scanner;

/**
 * Created by j_rus on 3/15/2017.
 */
public class find_min {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        if(n < 1){
            System.out.print("You need more then 1 number");
        }
        if(n == 2){
            System.out.print("min(int, int)");
            return;
        }
        int increment_by = 0;
        if(n %2 != 0)
            increment_by = 2;
        else
            increment_by =1;

        for (int i = 1; i <=n ; i+=increment_by) {

            if(i == n){
                sb.append("int");
            }else{
                sb.append("min(int, ");
            }
        }
        for (int i = 1; i <n ; i++){
            sb.append(")");
        }

        System.out.print(sb.toString());
    }
}
