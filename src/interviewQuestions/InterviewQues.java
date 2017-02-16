package interviewQuestions;

/**
 * Created by j_rus on 4/25/2016.
 */
public class InterviewQues {

    String reverse_words(String str){
        StringBuilder strBuldr = new StringBuilder();
        int counter = str.length();

        for(int i = str.length()-1; i>=0; i--){
            if(str.charAt(i) == ' '){
                strBuldr.append(str.substring(i, counter));
                strBuldr.append(" ");
                counter = i;
            }
            if(i == 0){
                strBuldr.append(str.substring(i, counter));
            }
        }

        return strBuldr.toString();
    }

    public static void main(String arg[]){

        InterviewQues iq = new InterviewQues();

        String newPharse = iq.reverse_words("find you will pain only go you recordings security the into if");
        System.out.print(newPharse);
    }
}
