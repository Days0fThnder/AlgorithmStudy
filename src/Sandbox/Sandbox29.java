package Sandbox;

public class Sandbox29 {

    static String amendTheSentence(String s) {
        int start = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= s.length()-1 ; i++) {
            if(i != 0 && Character.isUpperCase(s.charAt(i))){
                String sub = s.substring(start, i).concat(" ");
                sb.append(sub);
                start = i;
            }else if(i == s.length() -1 && !Character.isUpperCase(s.charAt(i))){
                String sub = s.substring(start, i+1);
                sb.append(sub);
            }
            if(i == s.length() -1 && Character.isUpperCase(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString().toLowerCase();
    }

    public static void main(String [] arg){
        String s = "CodefightsIsAwesomeA";
        String s2 = "HelloA";
        System.out.print(amendTheSentence(s2));
    }
}
