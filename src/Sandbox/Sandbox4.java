package Sandbox;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by j_rus on 3/4/2017.
 */
public class Sandbox4 {

    public int matching_parenthesis(String str, int pos){
        if(str == null || pos < 0){
            return -1;
        }

        boolean looking = true;
        for (int i = pos +1; i < str.length() ; i++) {
            if(str.charAt(i) == '('){
                looking = true;
            }else if (str.charAt(i) == ')'){
                if(!looking){
                    looking = true;
                }else {
                    return i;
                }
            }
        }

        return -1;
    }

    public Set<String> perms(String str){

        if(str == null){
            return null;
        }

        Set<String> results = new HashSet<>();
        int indx = 0;
        for (int i = 0; i < str.length(); i++){
            String mStr = swap(indx, i, str);
            results.add(mStr);
            rearrange(mStr, indx, results);
        }

        return results;

    }

    private void rearrange(String mStr, int indx, Set<String> results) {

        if(indx < mStr.length() -1){
            mStr = swap(indx, indx+1, mStr);
            results.add(mStr); indx++;
            rearrange(mStr, indx, results);
        }
    }

    private String swap(int i, int k, String str) {
        char [] c = str.toCharArray();
        char temp = c[i];
        c[i] = c[k];
        c[k] = temp;
        return new String(c);
    }

    private boolean try_something(){
        String nothing = null;
        String something = "something";
        if(nothing == something){
            return true;
        }else{
            return false;
        }
    }


    public static void main(String [] arg){
        Sandbox4 sb4 = new Sandbox4();
        /*String str = "012365(78)012";
        System.out.println(sb4.matching_parenthesis(str, 6 ));*/
        //sb4.perms("cats");
        System.out.print(sb4.try_something());
    }
}
