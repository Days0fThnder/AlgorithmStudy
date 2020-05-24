package pramp;

import leetCode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BudgetCut {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        // your code goes here
        Arrays.sort(grantsArray); // O(N*LogN)
        int n = grantsArray.length;
        double cap = newBudget/n;
        for(int i = 0; i < n; i++) { // O(N)
            if(grantsArray[i] < cap) {
                newBudget -= grantsArray[i];
                cap = (newBudget/(n-(1+i)));
            }else {
                grantsArray[i] = cap;
            }
        }

        return cap;
    }

    public static void main(String[] args) {
        double [] grants = {210,200,150,193,130,110,209,342,117};
        //210,200,150,193,130,110,209,342,117
        System.out.println(findGrantsCap(grants, 1530));
    }

}
