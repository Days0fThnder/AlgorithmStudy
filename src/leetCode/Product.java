package leetCode;

public class Product {

    public int[] productExceptSelf(int[] nums) {

        int len = nums.length-1;
        int [] outputArray = new int[len+1];

        outputArray[0] = 1;

        for(int i = 0; i<len; i++){
            outputArray[i+1] = outputArray[i] * nums[i];
        }

        int right = 1;

        for( int i = len; i>=0; i--){
            outputArray[i] = outputArray[i] * right;
            right = right * nums[i];
        }

        return outputArray;

    }

    public static void main(String [] args){
        Product product = new Product();
        int [] arr = {1,2,3,4};
        product.productExceptSelf(arr);
    }
}
