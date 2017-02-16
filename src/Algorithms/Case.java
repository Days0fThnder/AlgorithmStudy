package Algorithms;

import java.util.Scanner;

/**
 * Created by j_rus on 4/27/2016.
 */
public class Case {
    static void stairCase(int n) {
        if (n == 1) {
            System.out.println("#");
        } else {
            StringBuilder sb = new StringBuilder();
            String str = "#";
            for (int i = 1; i <= n; i++) {
                sb.append(str);
                System.out.println(sb.toString());
            }

        }
    }


    public static void main(String arg[]) {
        //Case.stairCase(6);
        //Scanner sc = new Scanner(System.in);
        //int t=sc.nextInt();


        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String A = sc.nextLine();
        System.out.print(A);
        /* Enter your code here. Print output to STDOUT.
        for (int i = A.length() - 1; i >= 0; i--) {
            sb.append(A.charAt(i));
        }

        if (sb.toString().equals(A)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }*/


    }
}


