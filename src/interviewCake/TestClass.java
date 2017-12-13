package interviewCake;

import nodes.ListNode;
import walletHub.TopPhrases;

public class TestClass {

    public static void main(String [] arg){
        TestClass tc = new TestClass();
        TopPhrases tp = new TopPhrases();
       /*int[][] a = {{1, 2, 3},
               {4, 5, 6},
               {7, 8, 9}};
       //tc.rotate(a);
        ListNode<Integer> l = new ListNode<>(0);
        l.addNode(new ListNode<>(1));
        l.addNode(new ListNode<>(2));
        tc.isListPalindrome(l);*/

       System.out.println(tc.isPalindrome(null));

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }

    boolean isListPalindrome(ListNode<Integer> l) {

        if(l == null){
            return true;
        }

        ListNode<Integer> prev = null;
        ListNode<Integer> curr;
        ListNode<Integer> nex;

        String value = "";
        String reValue = "";

        curr = l;

        while(curr.next != null){
            value += String.valueOf(curr.value);
            nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;

        }
        curr.next = prev;
        value += String.valueOf(curr.value);

        while(curr != null){
            reValue += String.valueOf(curr.value);
            curr = curr.next;
        }

        return value.equals(reValue);

    }

    boolean isPalindrome(String str){
        if(str == null){
            throw new NullPointerException("No string provided");
        }
        int start = 0;
        int end = str.length()-1;
        while (start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
