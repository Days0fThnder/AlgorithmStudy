package projectEuler;

/**
 * Created by j_rus on 2/7/2017.
 */
public class problem5 {

    public static int smallest_multiple(int lowEnd, int highEnd){
        int smallest_m = 1; int i = 0; boolean found = false;

        while(!found){
            i = lowEnd;
            while (i <= highEnd ) {
                if(smallest_m%i != 0){
                    break;
                }else{
                    i++;
                }
            }

            if(i > highEnd){
                found = true;
            }else{
                smallest_m++;
            }
        }
        return smallest_m;
    }


    public static void main(String [] arg){

        System.out.print(smallest_multiple(1, 20));
    }
}
