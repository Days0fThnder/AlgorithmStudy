package Arrays;

/**
 * Created by j_rus on 2/12/2017.
 */
public class Two_Dimensional_Array {

    //int [][] numbers = new int[3][3];

    public int traversal_search(int [][] numbers, int target) {
        for (int row = 0; row < numbers.length; row++){
            for (int col = 0; col < numbers[row].length; col++) {
                if(numbers[row][col] == target){
                    return numbers[row][col];
                }
            }
        }

        return -1;
    }

    public void diagonal_traversal(int [][] numbers){
        for (int row = 0; row < numbers.length-1; row++){
            System.out.print(numbers[row][row]);
        }
        System.out.println("");
        System.out.println("------------------------------");
        for (int row = 0; row < numbers.length-1; row++) {
             System.out.print(numbers[numbers.length - row -1][row]);
        }
    }

    public int arraySize(int [][] numbers){
        System.out.println("");
        System.out.println("------------------------------");
        return numbers.length;
    }

    public static void main(String [] args){
        int [][] numbers = {{1,2,3,},
                            {4,5,6,},
                            {7,8,9,},
                            {10,11,12}};
        Two_Dimensional_Array tda = new Two_Dimensional_Array();
        System.out.println(tda.traversal_search(numbers, 5));
        tda.diagonal_traversal(numbers);
        System.out.println(tda.arraySize(numbers));
    }
}
