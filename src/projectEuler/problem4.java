package projectEuler;

/**
 * Created by j_rus on 2/1/2017.
 */
public class problem4 {

    public static int largestPalProd(int digit){
        int starter = 9; int baseNum = 0; int multipler = 1;
        int lower_limit = 0; int baseMultipler =0; int product = 0;
        while(digit > 0){
            baseNum = starter * multipler;
            multipler = (multipler * 10) + 1;
            digit--;
        }
        baseMultipler = baseNum;
        lower_limit = baseNum/10;
        int temprod = 0;
        while(baseMultipler > lower_limit && baseNum > lower_limit){
            temprod = baseNum * baseMultipler;
            baseMultipler--;
            if(palindromeChecker(temprod) && temprod > product){
                product = temprod;
            }else{
                if(baseMultipler == lower_limit){
                    baseNum--;
                    baseMultipler = baseNum;
                }
            }
        }
        System.out.print(product);
        return product;
    }

    private static boolean palindromeChecker(int temprod) {

        String num = ""+temprod;
        int start = 0; int end = num.length()-1;
        int middle = (start+end)/2;

        while(start <= middle){
            if(num.charAt(start) == num.charAt(end)){
                start++; end--;
            }else{
                break;
            }
        }

        return middle+1 == start;
    }

    public static void main(String arg[]){
        largestPalProd(3);
    }
}
