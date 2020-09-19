package leetCode;

public class MaxSearch {

    public int thirdMax(int[] nums) {

        Integer first = nums[0];
        Integer second = null;
        Integer third = null;


        for(int i = 1; i < nums.length; i++){

            if(second == null){
                if(nums[i] < first) {
                    second = nums[i];
                }else if(nums[i] > first){
                    second = first;
                    first = nums[i];
                }
            }else if(second != null ){
                if(nums[i] > second && nums[i] < first){
                    second = nums[i];
                }else if(nums[i] > second && nums[i] > first) {
                    second = first;
                    first = nums[i];
                }
            }
        }

        if(nums.length < 3 || second == null){
            return first;
        }

        for(int i = 0; i < nums.length; i++){

            if(third == null && nums[i] < second){
                third = nums[i];
            }else if(third != null && nums[i] > third && nums[i] < second){
                third = nums[i];
            }
        }

        return third == null ? first : third;

    }

    public static void main(String [] args){
        MaxSearch maxSearch = new MaxSearch();
        int [] arr = {1,-2147483648,2};
        System.out.println(maxSearch.thirdMax(arr));
    }
}
