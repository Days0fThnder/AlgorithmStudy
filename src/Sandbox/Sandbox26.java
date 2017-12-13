package Sandbox;

/**
 * Created by j_rus on 7/6/2017.
 */
public class Sandbox26 {

    static char firstNotRepeatingCharacter(String s) {
        int[] count = new int[256];
        for (char c: s.toCharArray()) {
            count[c]++;
        }

        for (char c: s.toCharArray()) {
            if(count[c] == 1){
                return c;
            }
        }
        return '_';
    }

    public static void main(String[]arg){
        System.out.print(firstNotRepeatingCharacter("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof"));
    }

}
