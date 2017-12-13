package Sandbox;

/**
 * Created by j_rus on 7/10/2017.
 */
public class Sandbox27 {

    static int mapDecoding(String message){

        int counter = 0;
        if(message.length() == 0){
            return counter;
        }else if(!message.contains("0")){
            counter++;
            for (int i = 0; i < message.length() - 1; i++) {

                int num = Integer.parseInt(message.substring(i, i + 2));
                if(message.charAt(i) == '0' && counter > 1){
                    counter--;
                } else if (num <= 26) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String [] arg){
        mapDecoding("1001");
    }
}
