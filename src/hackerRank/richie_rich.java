package hackerRank;

import java.util.Scanner;

/**
 * Created by j_rus on 2/7/2017.
 */
public class richie_rich {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        System.out.print(largest_pal_value(n, k, number));
    }

    public static String largest_pal_value(int n, int k, String num){
        if(num == null){
            return "-1";
        }

        if (num.length() == 1){
            return num;
        }

        int low = 0; int high = n-1;
        int middle = (low+high)/2;
        char nums [] = num.toCharArray();
        StringBuffer sb = new StringBuffer();

        while (low <= middle){
            if(k > 0){
                if( k >= 2){
                    nums[low] ='9';
                    nums[high] ='9';
                    k -= 2;
                }else if(k == 1){
                    if(set_larger_val(nums, low, high, k)){
                        k--;
                    }
                }
            }
            low++; high--;
        }

        for (char ch : nums) {
            sb.append(ch);
        }

        Integer number = Integer.parseInt(sb.toString());

        if (palindromeChecker(number)){
            return number.toString();
        }else{
            return "-1";
        }

    }

    private static boolean set_larger_val(char nums[], int numA, int numB, int k) {

        if (nums[numA] > nums[numB]){
            nums[numB] = nums[numA];
            return true;
        }else if (nums[numA] < nums[numB]){
            nums[numA] = nums[numB];
            return true;
        }else{
            return false;
        }
    }

    private static boolean palindromeChecker(int temprod) {

        String num = ""+temprod;
        int start = 0; int end = num.length()-1;
        int middle = (start+end)/2;

        while(start <= middle){
            if(num.charAt(start) == num.charAt(end)){
                start++; end--;
            }else{
                break;
            }
        }

        return middle+1 == start;
    }
}
