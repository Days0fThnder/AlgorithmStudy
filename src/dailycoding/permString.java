package dailycoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class permString {

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans, List<Integer> nums, int num)
    {

        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            Integer currNum = Integer.parseInt(ans);
            if(currNum > num){
                nums.add(currNum);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            printPermutn(ros, ans + ch, nums, num);
        }

    }

    public static int removeDuplicates(ArrayList<Integer> a) {

        int i = 0;
        for (int j = 1; j < a.size(); j++)
            if (!a.get(i).equals(a.get(j)))
                a.set(++i, a.get(j));
        while (a.size() > i + 1)
            a.remove(a.size() - 1);
        return a.size();
    }

    // Driver code
    public static void main(String[] args)
    {
       /*Integer [] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
               0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2,
               2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
               3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };*/
       Integer [] arr = {1, 3, 4, 4, 5, 6};
       ArrayList<Integer> arrayList = new ArrayList<>();
       for(Integer in: arr){
           arrayList.add(in);
       }
       removeDuplicates(arrayList);

    }
}
