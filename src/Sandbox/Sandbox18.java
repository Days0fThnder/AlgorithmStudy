package Sandbox;

/**
 * Created by j_rus on 6/5/2017.
 */
public class Sandbox18 {

    static String swapLexOrder(String str, int[][] pairs){

        String swapedStr = "";
        String temp = str;
        String result = "";
        int i = 0;
        int idxA = 0;
        int idxB = 0;

        while (!swapedStr.equals(str)){
            if( i < pairs.length ) {
                idxA = pairs[i][0];
                idxB = pairs[i][1];
                i++;
            }else {
                i = 0;
                idxA = pairs[i][0];
                idxB = pairs[i][1];
                i++;
            }

            swapedStr = new String(swapedChar(idxA, idxB, temp));
            if(!swapedStr.equals(str) && !result.equals("")){

                result = new String(lexOrder(swapedStr, result));
            }else if (result.equals("")){
                result = new String(swapedStr);
            }

            temp = new String(swapedStr);
        }

        return result;
    }

    private static String lexOrder(String a, String b) {

        if(a.compareTo(b) < 0){
            return b;
        }else if(b.compareTo(a) < 0){
            return a;
        }else {
            return a;
        }
    }

    private static String swapedChar(int a, int b, String str) {

        StringBuilder sb = new StringBuilder(str);
        char first = str.charAt(a - 1);
        char second = str.charAt(b - 1);
        sb.setCharAt(a-1, second);
        sb.setCharAt(b-1, first);

        return sb.toString();
    }

    public static void main(String [] arg){
        int[][] pairs = {{1,4}, {3,4}};

        int [][] pairsA = {{1,3},{6,8},{3,8},{2,7}};
        swapLexOrder("acxrabdz", pairsA );
    }
}
