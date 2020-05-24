package hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MerchantSock {

    static int sockMerchant(int n, int[] ar) {

        if(n == 0){
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        Integer res = 0;
        for(int i = 0; i < ar.length; i++){
            if(freq.containsKey(ar[i])){
                freq.put(ar[i], freq.get(ar[i])+1);
            }else{
                freq.put(ar[i], 1);
            }
        }

        for(Integer in : freq.keySet()){
            Integer num = freq.get(in);
            num = num/2;
            res += num;
        }

        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = 9;
        int [] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(n, ar);

        scanner.close();
    }
}
