package projectEuler;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by j_rus on 3/7/2017.
 */
public class problem8 {

    public static Integer largest_product_in_series(String str, int series_len){

        Integer product = 0;
        Integer tempProduct = 1;
        int start = 0;
        int intial = 0;
        int marker = series_len;
        while (marker < str.length()) {
            if(intial <= marker){
                char c = str.charAt(intial);
                if(Character.getNumericValue(str.charAt(intial)) == 56){
                    System.out.println(c);
                }
                System.out.println(tempProduct +" = "+ tempProduct +" * "+Character.getNumericValue(str.charAt(intial)));
                tempProduct = tempProduct * Character.getNumericValue(str.charAt(intial));
                intial++;
                if(tempProduct < 0){
                    System.out.println(tempProduct);
                }
            }else{
                System.out.println(tempProduct);
                System.out.println("/---------------------------------------------------");
                intial = start+1;
                start++;
                marker++;
                if(tempProduct > product){
                    product = tempProduct;

                }
                tempProduct = 1;
            }
        }

        return product;
    }

    public static void main(String [] args){
        String num = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        //String str2 = "82166370484403199890008895243450658541227588666881";
        //System.out.println(largest_product_in_series(str, 12));
        /*String str2 = "0123456789";
        for (char ch: str2.toCharArray()) {
            System.out.println(Character.getNumericValue(ch));
        }*/

        long greatestProduct = 0;
        for (int i = 0; i < num.length() - 12; i++) {
            long prod = Character.getNumericValue(num.charAt(i))*
                    Character.getNumericValue(num.charAt(i+1))*
                    Character.getNumericValue(num.charAt(i+2))*
                    Character.getNumericValue(num.charAt(i+3))*
                    Character.getNumericValue(num.charAt(i+4))*
                    Character.getNumericValue(num.charAt(i+5))*
                    Character.getNumericValue(num.charAt(i+6))*
                    Character.getNumericValue(num.charAt(i+7))*
                    Character.getNumericValue(num.charAt(i+8))*
                    Character.getNumericValue(num.charAt(i+9))*
                    Character.getNumericValue(num.charAt(i+10))*
                    Character.getNumericValue(num.charAt(i+11))*
                    Character.getNumericValue(num.charAt(i+12));
            if (prod > greatestProduct)
                greatestProduct = prod;
        }
        System.out.println(greatestProduct);
        ArrayList<ArrayList<String>> grid = new ArrayList<>();
        grid.add(new ArrayList<>());
        Random ran = new Random();

        for (ArrayList<String> arr : grid) {

        }
    }

}
