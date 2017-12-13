package InterviewBits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Hashing {
    public int colorful(int a) {
        HashSet<Integer>hs=new HashSet<Integer>();
        ArrayList<Integer>arr=new ArrayList<Integer>();
        while(a>0){
            int p=a%10;
            arr.add(p);
            a=a/10;
        }
        Collections.reverse(arr);

        for(int i=0;i<arr.size();i++){
            int res=1;
            for(int j=i;j<arr.size();j++){
                res=res*arr.get(j);
                if(hs.contains(res)){
                    return 0;
                }
                else{
                    hs.add(res);
                }
            }
        }

        return 1;
    }

    public static void main(String [] arg){
        Hashing hs = new Hashing();
        hs.colorful(243);
    }

}
