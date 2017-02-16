package Algorithms;

/**
 * Created by j_rus on 4/20/2016.
 */
public class Algorithms {

    int binarySearch( int arr[], int target, int max, int min){

        if(max >= min) {
            int mid = (max + min) / 2;
            if (arr[mid] == target) {
                return target;
            } else if (arr[mid] < target) {
                return binarySearch(arr, target, max, mid+1);
            } else if (arr[mid] > target) {
                return binarySearch(arr, target, mid, min);
            }
        }
        return -1;
    }

    void quickSort( int arr[], int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        // pivot or midpoint calculation
        int pivot = arr[(higherIndex + lowerIndex)/2];
        while (i <= j){

            while (arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i <= j) {
                swapNumbers(arr, i, j);
                i++;
                j--;
            }
        }

        if (lowerIndex < j){
            quickSort(arr, lowerIndex, j);
        }
        if (i < higherIndex){
            quickSort(arr, i, higherIndex);
        }
    }

    void swapNumbers(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean twoMovies(int flightTime, int[] movieTime){

        for(int i=0; i<movieTime.length; i++){
            for(int k=0; k<movieTime.length; k++){
                if (i != k){
                    if (movieTime[i] + movieTime[k] == flightTime) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String arg[]){
        Algorithms algo = new Algorithms();
        /*int num[] = {1,3,4,5,8,16,17,18,19,20};
        int unSorted[] = {3,2,6,10,12,5,4,17,22,1};
        Algorithms algo = new Algorithms();

        int result = algo.binarySearch(num, 19, num.length-1, 0);
        System.out.println(result);
        int result2 = algo.binarySearch(num, 4, num.length-1, 0);
        System.out.println(result2);
        int result3 = algo.binarySearch(num, 22, num.length-1, 0);
        System.out.println(result3);
        algo.quickSort(unSorted, 0, unSorted.length-1);
        for(int i=0; i<=unSorted.length-1; i++){
            if(i < unSorted.length-1)
                System.out.print(unSorted[i]+", ");
            else
                System.out.print(unSorted[i]);
        }*/
        int num[] = {1,3,60,5,8,16,17,18,60,20};
        boolean twoFlims = algo.twoMovies(120, num);
        System.out.print(twoFlims);
    }
}
