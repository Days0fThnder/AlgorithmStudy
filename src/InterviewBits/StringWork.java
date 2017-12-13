package InterviewBits;

import java.util.ArrayList;

public class StringWork {

    public String longestCommonPrefix(ArrayList<String> a) {

        if( a == null || a.isEmpty()){
            return "";
        }
        int longestStringVal = findLongest(a);

        StringBuffer sb = new StringBuffer();
        int strIdx = -1;
        while (strIdx < longestStringVal){
            strIdx++;
            for (int i = 0; i < a.size(); i++) {
                if (strIdx < a.get(i).length()){
                    if(sb.length() == 0 || i == 0){
                        sb.append(a.get(i).charAt(strIdx));
                    }else{
                        if(a.get(i).charAt(strIdx) == sb.charAt(sb.length()-1)){
                            continue;
                        }else{
                            sb.deleteCharAt(sb.length()-1);
                            strIdx = longestStringVal;
                            break;
                        }
                    }
                }else if(!a.get(i).equals(a.get(0)) && !a.get(i).equals(sb.charAt(sb.length()-1)) ){
                    sb.deleteCharAt(sb.length()-1);
                    strIdx = longestStringVal;
                    break;
                }else{
                    strIdx = longestStringVal;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public int lengthOfLastWord(final String a) {

        if(a.length() == 0 || a.length() == 1){
            return 0;
        }

        for(int k = 0; k < a.length(); k++){
            if(a.charAt(k) == ' '){
                break;
            }else if (k == a.length()-1){
                return 0;
            }
        }

        int lenOfLast = 0;

        for(int i = a.length()-1; i >= 0; i--){
            if(i == a.length()-1 && a.charAt(i) == ' '){
                continue;
            }else if(a.charAt(i) != ' '){
                lenOfLast++;
            }else if(a.charAt(i) == ' ' && lenOfLast > 0){
                return lenOfLast;
            }
        }

        return lenOfLast;
    }

    private int findLongest(ArrayList<String> a) {

        int longestLen = 0;

        for (String str: a) {
            if(str.length() > longestLen){
                longestLen = str.length();
            }
        }

        return longestLen;
    }

    public static void main(String [] arg){
        ArrayList<String> a = new ArrayList<>();


        String[] arr = {"aaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" };
        for (String st: arr) {
           // a.add(st);
        }

        a.add("abcd");
        a.add("abcd");
        a.add("abc");

        StringWork sw = new StringWork();
        //sw.longestCommonPrefix(a);
        sw.lengthOfLastWord(" H Kv Scy  GX eUKm FwiY RGjNRDz ZXYNVdNSfKjf nMX ");
    }
}
