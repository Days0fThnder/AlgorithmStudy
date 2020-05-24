package dailycoding;

public class MinFinder {

    public int findMin(int[]arr){

        int start = 0;
        int end = arr.length-1;
        int mid = -1;
        int min = Integer.MAX_VALUE;

        while(start < end){
            mid = (end+start)/2;
            if(arr[mid] < arr[mid-1]&& arr[mid]<arr[mid+1]){
                return arr[mid];
            }

            if(arr[mid-1] < arr[mid] && arr[end] > arr[mid-1]){
                end = mid;
                min = Math.min(arr[mid-1], min);
            }

            if(arr[end] < arr[start]){
                start = mid+1;
            }

            if(start == end){
                min = arr[end];
            }
        }

        return min;
    }

    public static void main(String [] args){
        MinFinder minFinder = new MinFinder();
        int [] arr = {6,    7,10,4,5};
        //{7,10,3,4,5,6}
        System.out.println(minFinder.findMin(arr));
    }
}
