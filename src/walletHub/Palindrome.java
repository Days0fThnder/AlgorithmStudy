package walletHub;

public class Palindrome {
    /**This checks for a palindrome, it has an O(n) time complexity
     * since it has to run through the entire string in the
     * worst case. The space complexity is O(1) since no other data structure is created to
     * store extra data.*/
    boolean isPalindrome(String str){
        if(str == null){
            throw new NullPointerException("No string provided");
        }
        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if(Character.isWhitespace(str.charAt(start))){
                start++;
            }
            if(Character.isWhitespace(str.charAt(end))){
                end--;
            }
            if(Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
