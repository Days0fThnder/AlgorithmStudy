package projectEuler;

/**
 * Created by j_rus on 3/27/2017.
 */
public class problem9 {

    public static int [] pyth_triplet(int prod){
        int temp_prod = prod -1; int a = 0; int b = 0; int c = 0;
        double sqrt = Math.sqrt(temp_prod);
        int temp_num = (int)sqrt;
        boolean numbers_found = false;
        int not_found_flag = 0;

        while (!numbers_found || not_found_flag < 0){
            while (Math.pow(sqrt, 2) != Math.pow(temp_num, 2)){
                sqrt = Math.sqrt(temp_prod);
                temp_num = (int)sqrt;
                temp_prod --;
            }

            if(c == 0){
                c = (int)sqrt; sqrt = Math.sqrt(temp_prod);
            }else if (b == 0){
                b = (int)sqrt; sqrt = Math.sqrt(temp_prod);
            }else if (a == 0){
                a = (int)sqrt; sqrt = Math.sqrt(temp_prod);
            }else if(Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2) == prod){
                numbers_found = true;
            }else {
                int sum = (int)Math.pow(a,2)+(int)Math.pow(b,2)+(int)Math.pow(c,2);
                c = b;
                b = a;
                a = 0;
            }

            if(temp_prod == 0){
                not_found_flag = -1;
            }
        }

        int [] results = new int[3];
        results[0] = a;
        results[1] = b;
        results[2] = c;
        return results;

    }

    public static void main(String [] arg){
        pyth_triplet(1000);
    }
}
