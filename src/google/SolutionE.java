package google;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by j_rus on 10/14/2016.
 */
public class SolutionE {

    private String magazine;
    private String note;
    Map<String, Integer> magazineMap = new Hashtable<>();
    Map<String, Integer> noteMap = new Hashtable<>();

    public SolutionE(String magazine, String note) {
        this.magazine = magazine;
        this.note = note;
    }

    public boolean solve() {
        int frequency = 0;
        for (String retrieval: magazine.split(" ")) {
            if(magazineMap.containsKey(retrieval)){
                frequency = magazineMap.get(retrieval);
                magazineMap.put(retrieval, ++frequency);
            }else{
                magazineMap.put(retrieval, 1);
            }
        }
        for (String retrieval: note.split(" ")) {
            if(!magazineMap.containsKey(retrieval) || magazineMap.get(retrieval) == 0) {
                return false;
            }else{
                frequency = magazineMap.get(retrieval);
                magazineMap.put(retrieval, --frequency);
            }
        }
        return true;
    }


    public static boolean isBalanced(String expression) {
        Stack bracket = new Stack();

        for(int i =0; i<expression.length(); i++){
            if(expression.charAt(i) == '{' || expression.charAt(i) == '[' ||
                    expression.charAt(i) == '('){
                bracket.push(expression.charAt(i));
            }else if (expression.charAt(i) == '}' || expression.charAt(i) == ']' ||
                    expression.charAt(i) == ')'){
                while(!bracket.isEmpty()){
                    if(isPair(expression.charAt(i), (Character) bracket.peek())){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return false;
    }
    private static boolean isPair(char a, char b){
        if((a == '{' && b == '}')|| (a == '}' && b == '{')){
            return true;
        }
        if((a == '[' && b == ']')|| (a == ']' && b == '[')){
            return true;
        }
        if((a == '(' && b == ')')|| (a == ')' && b == '(')){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        SolutionE s = new SolutionE(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
