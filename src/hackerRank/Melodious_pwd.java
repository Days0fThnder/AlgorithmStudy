package hackerRank;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by j_rus on 3/15/2017.
 */
public class Melodious_pwd {

    static String aphaNah = "abcdefghijklmnopqrstuvwxz";
    static char [] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n',
            'p', 'q', 'r', 's', 't', 'v', 'x', 'z'};
    static char [] vowels = {'a', 'i', 'e', 'o', 'u'};
    static Set<Set<String>> results = new HashSet<>();

    public static void create_pwds(int n){


        int pwd_len = 0;
        for (char ch: aphaNah.toCharArray()) {
            String pwd = new String(ch+"");
            Set<String> mel_set = new HashSet<>();
            int cIndx = 0;
            int vIndx = 0;
            int set_size = 0;
            while(set_size < 24) {
                pwd_len = 1;
                if(pwd.equals(""))
                    pwd = pwd+ch;
                while (pwd_len < n) {
                    int lastCh = pwd.length() - 1;
                    if (isVowel(pwd.charAt(lastCh))) {
                        pwd = pwd + getConsonant(cIndx);
                        cIndx++;
                    } else {
                        pwd = pwd + getVowel(vIndx);
                        vIndx++;
                    }
                    pwd_len++;
                    //char last_ch = sb.toString().charAt(pwd_len);
                }
                if (pwd_len == n) {
                    if (!mel_set.contains(pwd)) {
                        mel_set.add(pwd);
                        set_size = mel_set.size();
                    }
                    String nPwd = new String();
                    pwd = nPwd;
                }
            }
            results.add(mel_set);
        }
    }

    private static char getConsonant(int idx) {
        Random rand = new Random();
        return consonants[idx];
    }

    private static char getVowel(int idx) {
        Random rand = new Random();
        return vowels[idx];
    }

    private static boolean isVowel(char ch){
        return ch == 'a' || ch == 'i' || ch == 'e'
                || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        create_pwds(n);

        for (Set<String> st: results) {
            for (String str: st) {
                System.out.println(str);
            }
            System.out.println("////////////////////////////");
        }
    }

}
