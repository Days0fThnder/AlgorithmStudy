package leetCode;

public class LongestPalindromeSub {

    public String longestPalindrome(String s) {
        if(s.length() == 1 || s.isEmpty()){
            return s;
        }

        if(s.length() == 2){
            if(isPalindrome(s))
                return s;
            else
                return s.substring(0,1);
        }

        int mid = (s.length()-1)/2;
        int start = mid-1;
        int end = mid+1;
        String sub = s.substring(mid, mid+1);
        int curSubLen = sub.length();

        while(start > 0 || end < s.length()){


            String palStr = s.charAt(start)+sub+s.charAt(end);
            if(isPalindrome(palStr)){
                sub = palStr;
                end++; start--;
            }

            if(start >= 0){
                palStr = s.charAt(start)+sub;
                if(isPalindrome(palStr)){
                    sub = palStr;
                    start--;
                }
            }

            if(end < s.length()){
                palStr = sub+s.charAt(end);
                if(isPalindrome(palStr)){
                    sub = palStr;
                    end++;
                }
            }

            if(start == 0 && end == s.length()-1) {
                palStr = s.charAt(start)+sub+s.charAt(end);
                if(isPalindrome(palStr)){
                    return palStr;
                }
                return sub;
            }else if(start < 0 || end > s.length()-1) {
                break;
            }


        }

        return sub;
    }

    private boolean isPalindrome(String s){
        if(s.length() == 1 ){
            return true;
        }
        int len = s.length()-1;
        if(s.charAt(0) == s.charAt(len)){
            return true;
        }

        return false;
    }

    public static void main(String [] args){
        LongestPalindromeSub palindromeSub = new LongestPalindromeSub();

        System.out.println(palindromeSub.longestPalindrome("babad"));
    }
}
