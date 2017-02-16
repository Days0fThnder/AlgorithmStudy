package google;

/**
 * Created by j_rus on 12/6/2016.
 */
public class Test2 {

    public void swap( int a, int b, char[] chArr){
        char temp = chArr[a];
        chArr[a] = chArr[b];
        chArr[b] = temp;
    }

    public void swapCharArr(char [] chArr, int low, int high){
        if(chArr.length <= 1){
            return;
        }
        if(chArr.length == 2){
           swap(0, 1, chArr);
        }

        while(low < high){
            swap(low, high, chArr );
            low++; high--;
        }
    }

    public String reverseWord(String message){
        if(message == null){
            return null;
        }
        int len = message.length() -1;
        int space = 0;

        char[] strChar = message.toCharArray();
        swapCharArr(strChar, 0, len);
        for (int i = 0; i <= len ; i++) {
            if (Character.isWhitespace(strChar[i])){
                swapCharArr(strChar, space, i-1);
                space = i+1;
            }else if(i == len){
                swapCharArr(strChar, space, i);
            }
        }

        System.out.println(new String(strChar));
        return strChar.toString();
    }

    public static long NchooseK(long total, long choose){
        if(total < choose)
            return 0;
        if(choose == 0 || choose == total)
            return 1;
        return (total * NchooseK(total-1,choose-1))/ choose;
    }

    public static Integer perm(int total, int places){
        if(places == 0){
            return 1;
        }

        return total * perm(total -1, places -1);
    }



    public static void main(String arg[] ){
        Test2 t2 = new Test2();

        ///t2.reverseWord("me reverse can you if");

        System.out.println(NchooseK(324, 6));
        System.out.println(perm(12, 3));
    }
}
